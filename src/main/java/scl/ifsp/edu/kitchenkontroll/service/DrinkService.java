package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.dto.DrinkDto;
import scl.ifsp.edu.kitchenkontroll.model.entity.Drink;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.DataBaseException;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.ResourceNotFoundException;
import scl.ifsp.edu.kitchenkontroll.repository.DrinkRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository repository;

    @Transactional(readOnly = true)
    public List<DrinkDto> findAll(){
        List<Drink> list = repository.findAll();
        return list.stream().map(drink -> new DrinkDto(drink)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<DrinkDto> findAllPaged(Pageable pageable){
        Page<Drink> page = repository.findAll(pageable);
        return page.map(drink -> new DrinkDto(drink));
    }

    @Transactional(readOnly = true)
    public DrinkDto findById(Long id){
        Optional<Drink> obj = repository.findById(id);
        Drink entity = obj.orElseThrow(() -> new ResourceNotFoundException("Drink not found."));
        return new DrinkDto(entity);
    }

    @Transactional
    public DrinkDto insert(DrinkDto dto){
        Drink entity = new Drink();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new DrinkDto(entity);
    }

    @Transactional
    public DrinkDto updateStatus(Long id, DrinkDto dto){
        Optional<Drink> obj = repository.findById(id);
        Drink entity = obj.orElseThrow(() -> new ResourceNotFoundException("Drink not found."));
        entity.setStatus(dto.getStatus());
        entity = repository.save(entity);
        return new DrinkDto(entity);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id " + id + " not found ");
        }
        catch(DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }

    }

    public void copyDtoToEntity(DrinkDto dto, Drink entity){
        entity.setTableNumber(dto.getTableNumber());
        entity.setPrice(dto.getPrice());
        entity.setItem(dto.getItem());
        entity.setDeliveryPreference(dto.isDeliveryPreference());
        entity.setTableNumber(dto.getTableNumber());
        entity.setStatus(dto.getStatus());

    }
}

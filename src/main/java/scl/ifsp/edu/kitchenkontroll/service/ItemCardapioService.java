package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.dto.DrinkDto;
import scl.ifsp.edu.kitchenkontroll.model.dto.ItemCardapioDto;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.model.entity.Drink;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.DataBaseException;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.ResourceNotFoundException;
import scl.ifsp.edu.kitchenkontroll.repository.ItemCardapioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCardapioService {

    @Autowired
    private ItemCardapioRepository repository;

    @Transactional(readOnly = true)
    public List<ItemCardapio> findAll() {
        List<ItemCardapio> list = repository.findAll();
        return list;
    }

    @Transactional(readOnly = true)
    public Page<ItemCardapio> findAllPaged(Pageable pageable) {
        Page<ItemCardapio> list =  repository.findAll(pageable);

        return list.map(x -> new ItemCardapio(x.getId(), x.getItemType(), x.getName(), x.getDescription(),
                x.getBasePrice(), x.getImgUrl(), x.getDrinks(), x.getPizzas()));
    }

    public List<ItemCardapio> findAllByType() {
        List<ItemCardapio> list = repository.findAllByTypeOnSale();
        return list;
    }

    public Page<ItemCardapio> findAllByTypePaged(Pageable pageable) {
        Page<ItemCardapio> list =  repository.findAllByTypeOnSale(pageable);

        return list.map(x -> new ItemCardapio(x.getId(), x.getItemType(), x.getName(), x.getDescription(),
                x.getBasePrice(), x.getImgUrl(), x.getDrinks(), x.getPizzas()));
    }

    @Transactional(readOnly = true)
    public ItemCardapioDto findById(Long id){
        Optional<ItemCardapio> obj = repository.findById(id);
        ItemCardapio entity = obj.orElseThrow(() -> new ResourceNotFoundException("Drink not found."));
        return new ItemCardapioDto(entity);
    }

    @Transactional
    public ItemCardapioDto insert(ItemCardapioDto dto){
        ItemCardapio entity = new ItemCardapio();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ItemCardapioDto(entity);
    }

    @Transactional
    public ItemCardapioDto update(Long id, ItemCardapioDto dto){
        Optional<ItemCardapio> obj = repository.findById(id);
        ItemCardapio entity = obj.orElseThrow(() -> new ResourceNotFoundException("Item not found."));
        entity.setName(dto.getName());
        entity.setBasePrice(dto.getBasePrice());
        entity.setImgUrl(dto.getImgUrl());
        entity.setItemType(dto.getItemType());
        entity = repository.save(entity);
        return new ItemCardapioDto(entity);
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

    public void copyDtoToEntity(ItemCardapioDto dto, ItemCardapio entity){
        entity.setName(dto.getName());
        entity.setBasePrice(dto.getBasePrice());
        entity.setImgUrl(dto.getImgUrl());
        entity.setItemType(dto.getItemType());
    }
}

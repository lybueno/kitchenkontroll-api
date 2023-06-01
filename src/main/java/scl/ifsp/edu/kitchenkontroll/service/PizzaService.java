package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.dto.PizzaDto;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.model.entity.Pizza;
import scl.ifsp.edu.kitchenkontroll.model.entity.Table;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.DataBaseException;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.ResourceNotFoundException;
import scl.ifsp.edu.kitchenkontroll.repository.AddonRepository;
import scl.ifsp.edu.kitchenkontroll.repository.ItemCardapioRepository;
import scl.ifsp.edu.kitchenkontroll.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

    @Autowired
    private AddonRepository addonRepository;

    @Autowired
    private TableService tableService;

    @Transactional(readOnly = true)
    public List<PizzaDto> findAll(){
        List<Pizza> list = repository.findAll();
        return list.stream().map(pizza -> new PizzaDto(pizza, pizza.getFlavors(), pizza.getAddons())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<PizzaDto> findAllPaged(Pageable pageable){
        Page<Pizza> page = repository.findAll(pageable);
        return page.map(pizza -> new PizzaDto(pizza, pizza.getFlavors(), pizza.getAddons()));
    }

    @Transactional(readOnly = true)
    public PizzaDto findById(Long id){
       Optional<Pizza> obj = repository.findById(id);
       Pizza entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pizza not found."));
       return new PizzaDto(entity, entity.getFlavors(), entity.getAddons());
    }

    @Transactional
    public PizzaDto insert(PizzaDto dto){
        Pizza entity = new Pizza();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PizzaDto(entity);
    }

    @Transactional
    public PizzaDto updateStatus(Long id, PizzaDto dto){
        Optional<Pizza> obj = repository.findById(id);
        Pizza entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pizza not found."));
        entity.setStatus(dto.getStatus());
        entity = repository.save(entity);
        return new PizzaDto(entity);
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

    public void copyDtoToEntity(PizzaDto dto, Pizza entity){
        entity.setTableNumber(dto.getTable_id());
        Table dtoTable = tableService.findById(entity.getTableNumber());
        entity.setTable(dtoTable);
        entity.setStatus(dto.getStatus());
        entity.setSize(dto.getSize());
        entity.setPrice(dto.getPrice());
        entity.setFlavors(dto.getFlavors());
        entity.setAddons(dto.getAddons());


        entity.getFlavors().clear();
        for(ItemCardapio flavor : dto.getFlavors()){
            Optional<ItemCardapio> obj = itemCardapioRepository.findById(flavor.getId());
            ItemCardapio item = obj.orElseThrow(() -> new ResourceNotFoundException("Flavor not found."));
            entity.getFlavors().add(item);
        }

        entity.getAddons().clear();
        for(Addon addon : dto.getAddons()){
            Optional<Addon> obj = addonRepository.findById(addon.getId());
            Addon item = obj.orElseThrow(() -> new ResourceNotFoundException("Addon note found."));
            entity.getAddons().add(item);
        }

    }

}

package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.dto.PizzaDto;
import scl.ifsp.edu.kitchenkontroll.model.entity.Drink;
import scl.ifsp.edu.kitchenkontroll.model.entity.Pizza;
import scl.ifsp.edu.kitchenkontroll.model.entity.Table;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.ResourceNotFoundException;
import scl.ifsp.edu.kitchenkontroll.repository.DrinkRepository;
import scl.ifsp.edu.kitchenkontroll.repository.PizzaRepository;
import scl.ifsp.edu.kitchenkontroll.repository.TableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Transactional(readOnly = true)
    public List<Table> findAll() {
        List<Table> list = tableRepository.findAll();
        for (Table table: list) {
            List<Pizza> pizzas = pizzaRepository.findAllByTableId(table.getId());
            List<Drink> drinks = drinkRepository.findAllByTableId(table.getId());
            table.setPizzas(pizzas);
            table.setDrinks(drinks);
        }
        return list;
    }

    @Transactional(readOnly = true)
    public Page<Table> findAllPaged(Pageable pageable) {
        Page<Table> list =  tableRepository.findAll(pageable);

        for (Table table: list) {
            List<Pizza> pizzas = pizzaRepository.findAllByTableId(table.getId());
            List<Drink> drinks = drinkRepository.findAllByTableId(table.getId());
            table.setPizzas(pizzas);
            table.setDrinks(drinks);
        }
        return list;
    }

    @Transactional(readOnly = true)
    public Table findById(Long id) {
        Optional<Table> obj = tableRepository.findById(id);
        Table entity = obj.orElseThrow(() -> new ResourceNotFoundException("Table not found."));
        return entity;
    }

    @Transactional(readOnly = false)
    public void update(Table table){
        if (verifyTable(table))
            tableRepository.save(table);
    }

    boolean verifyTable(Table table){
        Optional<Table> obj = tableRepository.findById(table.getId());
        obj.orElseThrow(() -> new ResourceNotFoundException("Table not found."));
        return true;
    }
}

package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import scl.ifsp.edu.kitchenkontroll.model.entity.Drink;
import scl.ifsp.edu.kitchenkontroll.model.entity.Pizza;
import scl.ifsp.edu.kitchenkontroll.model.entity.Table;
import scl.ifsp.edu.kitchenkontroll.repository.DrinkRepository;
import scl.ifsp.edu.kitchenkontroll.repository.PizzaRepository;
import scl.ifsp.edu.kitchenkontroll.repository.TableRepository;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private DrinkRepository drinkRepository;

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
}

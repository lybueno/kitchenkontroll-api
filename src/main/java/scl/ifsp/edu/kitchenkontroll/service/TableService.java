package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import scl.ifsp.edu.kitchenkontroll.model.entity.Table;
import scl.ifsp.edu.kitchenkontroll.repository.TableRepository;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository repository;

    public List<Table> findAll() {
        List<Table> list = repository.findAll();
        return list;
    }

    public Page<Table> findAllPaged(Pageable pageable) {
        Page<Table> list =  repository.findAll(pageable);

        return list.map(x -> new Table(x.getId(), x.getPizzas(), x.getDrinks()));
    }
}

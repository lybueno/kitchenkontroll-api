package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scl.ifsp.edu.kitchenkontroll.model.dto.PizzaDto;
import scl.ifsp.edu.kitchenkontroll.model.entity.Table;
import scl.ifsp.edu.kitchenkontroll.service.TableService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/tables")
public class TableController {

    @Autowired
    private TableService service;

    @GetMapping
    public ResponseEntity<List<Table>> getAll(){
        List<Table> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Table>> getAllPaged(Pageable pageable){
        Page<Table> list = service.findAllPaged(pageable);
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Table> findById(@PathVariable Long id) {
        Table table = service.findById(id);
        return ResponseEntity.ok().body(table);
    }

    @PutMapping
    public ResponseEntity<Table> update(@RequestBody Table table){
        service.update(table);
        return ResponseEntity.ok().body(table);
    }

    // TODO: fazer requisição para create, update e delete

}

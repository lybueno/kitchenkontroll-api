package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scl.ifsp.edu.kitchenkontroll.model.entity.Table;
import scl.ifsp.edu.kitchenkontroll.service.TableService;

import java.util.List;

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
}

package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.service.ItemCardapioService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/cardapio")
public class ItemCardapioController {

    @Autowired
    private ItemCardapioService service;

    @GetMapping
    public ResponseEntity<List<ItemCardapio>> getAll(){
        List<ItemCardapio> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<ItemCardapio>> getAllPaged(Pageable pageable){
        Page<ItemCardapio> list = service.findAllPaged(pageable);
        return  ResponseEntity.ok().body(list);
    }
}

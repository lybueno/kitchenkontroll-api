package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scl.ifsp.edu.kitchenkontroll.model.dto.ItemCardapioDto;
import scl.ifsp.edu.kitchenkontroll.model.dto.PizzaDto;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.service.ItemCardapioService;

import java.net.URI;
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

    @GetMapping(value = "/on-sale")
    public ResponseEntity<List<ItemCardapio>> getAllOnSale(){
        List<ItemCardapio> list = service.findAllByType();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/on-sale/paged")
    public ResponseEntity<Page<ItemCardapio>> getAllOnSalePaged(Pageable pageable){
        Page<ItemCardapio> list = service.findAllByTypePaged(pageable);
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemCardapioDto> findById(@PathVariable Long id) {
        ItemCardapioDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ItemCardapioDto> insert(@RequestBody ItemCardapioDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ItemCardapioDto> updateStatus(@PathVariable Long id, @RequestBody ItemCardapioDto dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scl.ifsp.edu.kitchenkontroll.model.dto.PizzaDto;
import scl.ifsp.edu.kitchenkontroll.service.PizzaService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService service;

    @GetMapping
    public ResponseEntity<List<PizzaDto>> findAll(){
        List<PizzaDto> addons = service.findAll();
        return  ResponseEntity.ok().body(addons);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<PizzaDto>> findAllPaged(Pageable pageable){
        Page<PizzaDto> pizzas = service.findAllPaged(pageable);
        return  ResponseEntity.ok().body(pizzas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PizzaDto> findById(@PathVariable Long id) {
        PizzaDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<PizzaDto> insert(@RequestBody PizzaDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<PizzaDto> updateStatus(@PathVariable Long id, @RequestBody PizzaDto dto){
        dto = service.updateStatus(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

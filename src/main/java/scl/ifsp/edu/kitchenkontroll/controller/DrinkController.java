package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import scl.ifsp.edu.kitchenkontroll.model.dto.DrinkDto;
import scl.ifsp.edu.kitchenkontroll.service.DrinkService;


import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/drinks")
public class DrinkController {

    @Autowired
    private DrinkService service;

    @GetMapping
    public ResponseEntity<List<DrinkDto>> findAll(){
        List<DrinkDto> addons = service.findAll();
        return  ResponseEntity.ok().body(addons);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<DrinkDto>> findAllPaged(Pageable pageable){
        Page<DrinkDto> drinks = service.findAllPaged(pageable);
        return  ResponseEntity.ok().body(drinks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DrinkDto> findById(@PathVariable Long id) {
        DrinkDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<DrinkDto> insert(@RequestBody DrinkDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<DrinkDto> updateStatus(@PathVariable Long id, @RequestBody DrinkDto dto){
        dto = service.updateStatus(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

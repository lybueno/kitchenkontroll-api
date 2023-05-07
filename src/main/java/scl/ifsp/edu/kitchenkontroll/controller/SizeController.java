package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scl.ifsp.edu.kitchenkontroll.model.entity.Size;
import scl.ifsp.edu.kitchenkontroll.service.SizeService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/sizes")
public class SizeController {

    @Autowired
    private SizeService service;

    @GetMapping
    public ResponseEntity<List<Size>> getAll(){
        List<Size> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Size>> getAllPaged(Pageable pageable){
        Page<Size> list = service.findAllPaged(pageable);
        return  ResponseEntity.ok().body(list);
    }
}

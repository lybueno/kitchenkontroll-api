package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.service.AddonService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/addons")
public class AddonController {

    @Autowired
    private AddonService addonService;

    @GetMapping
    public ResponseEntity<List<Addon>> getAll(){
        List<Addon> addons = addonService.findAll();
        return  ResponseEntity.ok().body(addons);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Addon>> getAllPaged(Pageable pageable){
        Page<Addon> addons = addonService.findAllPaged(pageable);
        return  ResponseEntity.ok().body(addons);
    }
}

package scl.ifsp.edu.kitchenkontroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.service.AddonService;

import java.util.List;

@RestController
@RequestMapping(value = "/addons")
public class AddonController {

    @Autowired
    private AddonService addonService;

    @GetMapping
    public ResponseEntity<List<Addon>> getAll(){
        return null;
    }
}

package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.repository.AddonRepository;

import java.util.List;

@Service
public class AddonService {

    @Autowired
    private AddonRepository repository;

    @Transactional(readOnly = true)
    public List<Addon> findAll() {
        List<Addon> list = repository.findAll();
        return list;
    }

    @Transactional(readOnly = true)
    public Page<Addon> findAllPaged(Pageable pageable) {
        Page<Addon> list =  repository.findAll(pageable);

        return list.map(x -> new Addon(x.getId(), x.getName(), x.getPrice(), x.getAddonType(), x.getPizzaBagItems()));
    }
}

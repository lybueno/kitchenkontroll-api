package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.entity.Size;
import scl.ifsp.edu.kitchenkontroll.repository.SizeRepository;

import java.util.List;

@Service
public class SizeService {

    @Autowired
    private SizeRepository repository;

    @Transactional(readOnly = true)
    public List<Size> findAll() {
        List<Size> list = repository.findAll();
        return list;
    }

    @Transactional(readOnly = true)
    public Page<Size> findAllPaged(Pageable pageable) {
        Page<Size> list =  repository.findAll(pageable);

        return list.map(x -> new Size(x.getId(), x.getSize(), x.getMultiplier(), x.getPizzas()));
    }
}

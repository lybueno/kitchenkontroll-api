package scl.ifsp.edu.kitchenkontroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.repository.ItemCardapioRepository;

import java.util.List;

@Service
public class ItemCardapioService {

    @Autowired
    private ItemCardapioRepository repository;

    @Transactional(readOnly = true)
    public List<ItemCardapio> findAll() {
        List<ItemCardapio> list = repository.findAll();
        return list;
    }

    @Transactional(readOnly = true)
    public Page<ItemCardapio> findAllPaged(Pageable pageable) {
        Page<ItemCardapio> list =  repository.findAll(pageable);

        return list.map(x -> new ItemCardapio(x.getId(), x.getItemType(), x.getName(), x.getDescription(),
                x.getBasePrice(), x.getImgUrl(), x.getDrinks(), x.getPizzas()));
    }
}

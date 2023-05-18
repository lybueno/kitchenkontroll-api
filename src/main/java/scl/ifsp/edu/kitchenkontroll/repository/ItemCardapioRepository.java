package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;

import java.util.List;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio,Long> {

    @Query("SELECT i FROM ItemCardapio i WHERE i.itemType = 2")
    List<ItemCardapio> findAllByTypeOnSale();

    @Query("SELECT i FROM ItemCardapio i WHERE i.itemType = 2")
    Page<ItemCardapio> findAllByTypeOnSale(Pageable pageable);
}

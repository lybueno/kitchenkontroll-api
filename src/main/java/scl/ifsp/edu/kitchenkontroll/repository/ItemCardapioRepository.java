package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.model.entity.Pizza;

import java.util.List;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio,Long> {

    @Query("SELECT i FROM ItemCardapio i WHERE i.itemType = 2")
    List<ItemCardapio> findAllByTypeOnSale();

    @Query("SELECT i FROM ItemCardapio i WHERE i.itemType = 2")
    Page<ItemCardapio> findAllByTypeOnSale(Pageable pageable);


    @Query("select max(id) from ItemCardapio")
    Long findLastId();

    @Modifying
    @Transactional
    @Query(value = "INSERT into Item_Cardapio (id, item_type, name, description, base_price, img_url) VALUES (:#{#entity.id}, :#{#entity.itemType.value}, :#{#entity.name}, :#{#entity.description}, :#{#entity.basePrice}, :#{#entity.imgUrl})", nativeQuery = true)
    void insertItemCardapio(@Param("entity") ItemCardapio entity);
}

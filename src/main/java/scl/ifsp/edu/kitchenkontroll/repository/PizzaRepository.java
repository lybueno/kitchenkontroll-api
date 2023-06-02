package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.model.entity.Pizza;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    @Query("select i from Pizza i where i.table.id=?1")
    List<Pizza> findAllByTableId(@Param("table") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT into ADDONS_PIZZA (ADDON_ID, PIZZA_ID) VALUES (:#{#addon.id}, :#{#entity.id})", nativeQuery = true)
    void insertPizzaInAddons(@Param("entity")Pizza entity, @Param("addon")Addon addon);

    @Modifying
    @Transactional
    @Query(value = "INSERT into PIZZAS_ITEM_CARDAPIO (PIZZA_ID, ITEM_CARDAPIO_ID) VALUES (:#{#item.id}, :#{#entity.id})", nativeQuery = true)
    void insertPizzaInItemCardapio(@Param("entity")Pizza entity, @Param("item")ItemCardapio item);

    @Query("select max(id) from Pizza")
    Long findLastId();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pizza(id, price, table_id, status, size_id, table_number) VALUES(:#{#entity.id}, :#{#entity.price},:#{#entity.table.id},:#{#entity.status.value} ,:#{#entity.size.id}, :#{#entity.tableNumber});", nativeQuery = true)
    void insertPizza(@Param("entity")Pizza entity);
}

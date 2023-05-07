package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import scl.ifsp.edu.kitchenkontroll.model.entity.Pizza;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    @Query("select i from Pizza i where i.table.id=?1")
    List<Pizza> findAllByTableId(@Param("table") Long id);
}

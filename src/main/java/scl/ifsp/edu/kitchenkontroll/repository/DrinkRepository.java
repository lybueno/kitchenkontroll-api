package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import scl.ifsp.edu.kitchenkontroll.model.entity.Drink;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    @Query("select i from Drink i where i.table.id=?1")
    List<Drink> findAllByTableId(@Param("table") Long id);
}

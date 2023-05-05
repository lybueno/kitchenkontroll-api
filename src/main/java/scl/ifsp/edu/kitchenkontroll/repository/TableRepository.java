package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scl.ifsp.edu.kitchenkontroll.model.entity.Table;

public interface TableRepository extends JpaRepository<Table, Long> {
}

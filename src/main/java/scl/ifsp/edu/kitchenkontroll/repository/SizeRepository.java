package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scl.ifsp.edu.kitchenkontroll.model.entity.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
}

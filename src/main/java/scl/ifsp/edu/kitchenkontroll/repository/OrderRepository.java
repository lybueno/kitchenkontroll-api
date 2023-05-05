package scl.ifsp.edu.kitchenkontroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scl.ifsp.edu.kitchenkontroll.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

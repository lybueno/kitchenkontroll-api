package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;


    public Double calculatePrice(){
        return null;
    }
}

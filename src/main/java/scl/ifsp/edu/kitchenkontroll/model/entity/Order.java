package scl.ifsp.edu.kitchenkontroll.model.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;

import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.*;
import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.DELIVERED;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    private Status status;


    public Double calculatePrice(){
        return null;
    }
}

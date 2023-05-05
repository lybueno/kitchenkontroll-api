package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_table")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "table")
    private List<Item> cart;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;

}

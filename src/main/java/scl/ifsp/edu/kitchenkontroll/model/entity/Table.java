package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "table")
    private List<Item> cart;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;

}

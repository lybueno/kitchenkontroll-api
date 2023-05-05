package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;
import scl.ifsp.edu.kitchenkontroll.model.enums.ItemType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ItemType itemType;
    private String name;
    private String description;
    private Double basePrice;
    private String imgUrl;

    @OneToMany(mappedBy = "item")
    private List<Drink> drinks;

    @ManyToMany
    @JoinTable(name = "pizzas_itemCardapio",
            joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "itemCardapio_id",
                    referencedColumnName = "id"))
    private List<Pizza> pizzas;
}

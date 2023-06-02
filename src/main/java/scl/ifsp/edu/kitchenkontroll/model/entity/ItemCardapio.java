package scl.ifsp.edu.kitchenkontroll.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;
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

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Drink> drinks;

    @JsonIgnore
    @ManyToMany(mappedBy = "flavors")
    private List<Pizza> pizzas;
}

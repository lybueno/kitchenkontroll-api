package scl.ifsp.edu.kitchenkontroll.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import scl.ifsp.edu.kitchenkontroll.model.enums.ItemType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ItemType itemType;
    private String name;
    private String description;
    private Double basePrice;
    private String imgUrl;

    @OneToMany(mappedBy = "item")
    private List<DrinkBagItem> drinkBagItems;

    @ManyToMany(mappedBy ="flavors")
    private List<PizzaBagItem> pizzaBagItems;
}

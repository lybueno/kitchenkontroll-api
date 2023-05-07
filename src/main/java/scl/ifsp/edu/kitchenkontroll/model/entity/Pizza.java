package scl.ifsp.edu.kitchenkontroll.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import scl.ifsp.edu.kitchenkontroll.model.enums.AddonType;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.FlavorLimitReachedException;


import java.util.List;

import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.*;
import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.DELIVERED;

@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    private Long tableNumber;

    private float price;

    @ManyToMany(mappedBy = "pizzas")
    private List<ItemCardapio> flavors;

    @ManyToMany
    @JoinTable(name = "addons_pizza",
            joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "addon_id",
                    referencedColumnName = "id"))
    private List<Addon> addons;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    private Status status;

    public void updateStatus(){
        if(status == REQUESTED){
            status = PREPARING;
        }
        else if(status == PREPARING){
            status = DONE;
        }
        else{
            status = DELIVERED;
        }
    }


    public void addAddon(Addon addon){
        addons.add(addon);
    }

    public void addFlavor(ItemCardapio flavor){
        if(flavors.size() <= 1){
            flavors.add(flavor);
        } else {
            throw new FlavorLimitReachedException("Limite máximo de sabores atingido");
        }
    }

    public Double sumAddons(){
        Double sumAddon = 0.0;
        for (Addon addon : addons) {
            sumAddon+=addon.getPrice();
        }
        return sumAddon;
    }

    public Double calculatePrice(){
        Double sumFlavors;
        if(!isDoubleFlavor())
            sumFlavors = flavors.get(0).getBasePrice();
        else
            sumFlavors = (flavors.get(0).getBasePrice() + flavors.get(1).getBasePrice())/2;
        return (sumFlavors * size.getMultiplier()) + sumAddons();
    }

    private boolean isBorderAlreadySelected(){
        return addons.stream().anyMatch(addon -> addon.getAddonType() == AddonType.BORDER);
    }

    public boolean isDoubleFlavor(){
        if(flavors.size() == 2)
            return true;
        return false;
    }

}

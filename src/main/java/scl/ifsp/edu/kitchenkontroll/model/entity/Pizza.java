package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;
import scl.ifsp.edu.kitchenkontroll.model.enums.AddonType;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.FlavorLimitReachedException;


import java.util.List;


@Entity
public class Pizza extends Item {

    @ManyToMany
    @JoinTable(name = "items_pizza",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id",
                    referencedColumnName = "id"))
    private List<ItemCardapio> flavors;

    @ManyToMany
    @JoinTable(name = "addons_pizza",
            joinColumns = @JoinColumn(name = "addon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id",
                    referencedColumnName = "id"))
    private List<Addon> addons;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;


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

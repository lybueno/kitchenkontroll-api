package scl.ifsp.edu.kitchenkontroll.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import scl.ifsp.edu.kitchenkontroll.model.enums.AddonType;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.BorderLimitExeception;
import scl.ifsp.edu.kitchenkontroll.model.utils.exceptions.FlavorLimitReachedException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PizzaBagItem extends BagItem{

    private String observation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "item_pizza",
    joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "pizzaBagItem_id", referencedColumnName = "id"))
    private List<Item> flavors;

    @ManyToOne
    @JoinColumn(name = "pizzaBagItem_id")
    private Size size;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "addon_pizza",
    joinColumns = @JoinColumn(name = "addon_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "pizzaBagItem_id", referencedColumnName = "id"))
    private List<Addon> addons;


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


    public void addFlavor(Item flavor){
        if(flavors.size() < 2)
            flavors.add(flavor);
        else{
            throw new FlavorLimitReachedException("Limite máximo de sabores atingido");
        }
    }

    private boolean isBorderAlreadySelected(){
        return addons.stream().anyMatch(addon -> addon.getAddonType() == AddonType.BORDER);
    }

    public void addAddon(Addon addon){
       if(addon.getAddonType() == AddonType.BORDER && isBorderAlreadySelected()){
        throw new BorderLimitExeception("Já foi adiocionado um tipo de borda à pizza.");
       } else{
        addons.add(addon);
       }
    }

    public boolean isDoubleFlavor(){
        if(flavors.size() == 2)
            return true;
        return false;
    }
}

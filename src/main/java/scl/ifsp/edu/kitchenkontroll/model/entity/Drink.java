package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Drink extends Item {

    @ManyToOne
    @JoinColumn(name = "itemCardapio_id")
    private ItemCardapio item;
    private boolean deliveryPreference;


    public Double calculatePrice(){
        return item.getBasePrice();
    }



}

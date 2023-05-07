package scl.ifsp.edu.kitchenkontroll.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;

import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.*;
import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.DELIVERED;

@Data
@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @ManyToOne
    @JoinColumn(name = "itemCardapio_id")
    private ItemCardapio item;

    private boolean deliveryPreference;

    private Long tableNumber;

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


    public Double calculatePrice(){
        return item.getBasePrice();
    }



}

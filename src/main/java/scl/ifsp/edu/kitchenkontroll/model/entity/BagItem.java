package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;
import lombok.Setter;
import lombok.Getter;

import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.*;

@Getter
@Setter
@Entity
public abstract class BagItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float finalPrice;
    private int table;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "bagItem_id")
    private Bag bag;

    public void updateStatus(){
        if(status == DELIVERED){
            status = PREPARING;
        }
        else if(status == PREPARING){
            status = DONE;
        }
        else{
            status = DELIVERED;
        }
    }

    public abstract Double calculatePrice();
}

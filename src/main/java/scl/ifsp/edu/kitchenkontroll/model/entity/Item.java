package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;

import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.*;
import static scl.ifsp.edu.kitchenkontroll.model.enums.Status.DELIVERED;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float price;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

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
}

package scl.ifsp.edu.kitchenkontroll.model.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<BagItem> bagItems;

    public void updateOrderStatus(BagItem bagItem){
        if(bagItems.contains(bagItem)){
            bagItem.updateStatus();
        }
    }
}

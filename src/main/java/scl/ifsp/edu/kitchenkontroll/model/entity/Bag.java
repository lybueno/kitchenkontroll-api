package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "bag")
    private List<BagItem> bagItems;
    
        
    public void addItem(BagItem bagItem){
        this.bagItems.add(bagItem);
    }

    public void removeItem(BagItem bagItem){
        this.bagItems.remove(bagItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bag bag = (Bag) o;
        return id != null && Objects.equals(id, bag.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

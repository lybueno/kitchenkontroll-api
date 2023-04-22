package scl.ifsp.edu.kitchenkontroll.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class DrinkBagItem extends BagItem{

    @ManyToOne
    @JoinColumn(name="drink_id")
    private Item item;
    private Boolean deliverPreference;

    public Double calculatePrice(){
        return item.getBasePrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DrinkBagItem that = (DrinkBagItem) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

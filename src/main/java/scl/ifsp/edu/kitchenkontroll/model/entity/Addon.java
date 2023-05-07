package scl.ifsp.edu.kitchenkontroll.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import scl.ifsp.edu.kitchenkontroll.model.enums.AddonType;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;
    private AddonType addonType;

    @JsonIgnore
    @ManyToMany(mappedBy = "addons")
    private List<Pizza> pizzaBagItems;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Addon addon = (Addon) o;
        return id != null && Objects.equals(id, addon.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

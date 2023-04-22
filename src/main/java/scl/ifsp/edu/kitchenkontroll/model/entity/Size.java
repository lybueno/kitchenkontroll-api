package scl.ifsp.edu.kitchenkontroll.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import scl.ifsp.edu.kitchenkontroll.model.enums.SizeLabel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SizeLabel size;
    private Double multiplier;

    @OneToMany(mappedBy="size")
    private List<PizzaBagItem> pizzaBagItems;

}

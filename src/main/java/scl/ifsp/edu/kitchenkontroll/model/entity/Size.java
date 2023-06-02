package scl.ifsp.edu.kitchenkontroll.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import scl.ifsp.edu.kitchenkontroll.model.enums.SizeLabel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SizeLabel size;
    private Double multiplier;

    @JsonIgnore
    @OneToMany(mappedBy="size")
    private List<Pizza> pizzas;

}

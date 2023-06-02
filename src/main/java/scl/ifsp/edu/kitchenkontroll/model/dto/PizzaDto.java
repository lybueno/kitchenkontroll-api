package scl.ifsp.edu.kitchenkontroll.model.dto;

import lombok.Getter;
import lombok.Setter;
import scl.ifsp.edu.kitchenkontroll.model.entity.Addon;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.model.entity.Pizza;
import scl.ifsp.edu.kitchenkontroll.model.entity.Size;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PizzaDto {

    private Long id;
    private Status status;
    private Long table_id;
    private List<ItemCardapio> flavors = new ArrayList<>();
    private Double price;
    private Size size;
    private List<Addon> addons = new ArrayList<>();

    public PizzaDto(){

    }

    public PizzaDto(Long id, Status status, Long table_id, Double price, Size size) {
        this.id = id;
        this.status = status;
        this.table_id = table_id;
        this.price = price;
        this.size = size;
    }

    public PizzaDto(Pizza entity){
        this.id =entity.getId();
        this.table_id = entity.getTableNumber();
        this.status = entity.getStatus();
        this.price = entity.getPrice();
        this.size = entity.getSize();
        this.flavors = entity.getFlavors();
        this.addons = entity.getAddons();
    }

    public PizzaDto(Pizza entity, List<ItemCardapio> flavors, List<Addon> addons){
        this(entity);
        this.flavors.addAll(flavors);
        this.addons.addAll(addons);
    }

    @Override
    public String toString() {
        return "PizzaDto{" +
                "id=" + id +
                ", status=" + status +
                ", table_id=" + table_id +
                ", flavors=" + flavors +
                ", price=" + price +
                ", size=" + size +
                ", addons=" + addons +
                '}';
    }
}

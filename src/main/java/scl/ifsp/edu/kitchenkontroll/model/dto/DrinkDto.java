package scl.ifsp.edu.kitchenkontroll.model.dto;

import lombok.Getter;
import lombok.Setter;
import scl.ifsp.edu.kitchenkontroll.model.entity.Drink;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.model.enums.Status;

@Getter
@Setter
public class DrinkDto {

    private Long id;
    private Double price;
    private ItemCardapio item;
    private boolean deliveryPreference;
    private Long tableNumber;
    private Status status;

    public DrinkDto() {
    }

    public DrinkDto(Long id, Double price, ItemCardapio item, boolean deliveryPreference, Long tableNumber, Status status) {
        this.id = id;
        this.price = price;
        this.item = item;
        this.deliveryPreference = deliveryPreference;
        this.tableNumber = tableNumber;
        this.status = status;
    }

    public DrinkDto(Drink entity){
        this.id = entity.getId();
        this.price = entity.getPrice();
        this.item = entity.getItem();
        this.deliveryPreference = entity.isDeliveryPreference();
        this.tableNumber = entity.getTableNumber();
        this.status = entity.getStatus();
    }


    @Override
    public String toString() {
        return "DrinkDto{" +
                "id=" + id +
                ", price=" + price +
                ", item=" + item +
                ", deliveryPreference=" + deliveryPreference +
                ", tableNumber=" + tableNumber +
                ", status=" + status +
                '}';
    }
}

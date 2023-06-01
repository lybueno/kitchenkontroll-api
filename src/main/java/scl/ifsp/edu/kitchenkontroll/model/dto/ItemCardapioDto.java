package scl.ifsp.edu.kitchenkontroll.model.dto;

import lombok.Getter;
import lombok.Setter;
import scl.ifsp.edu.kitchenkontroll.model.entity.ItemCardapio;
import scl.ifsp.edu.kitchenkontroll.model.enums.ItemType;

@Getter
@Setter
public class ItemCardapioDto {

    private Long id;
    private ItemType itemType;
    private String name;
    private String description;
    private Double basePrice;
    private String imgUrl;

    public ItemCardapioDto() {
    }

    public ItemCardapioDto(Long id, ItemType itemType, String name, String description, Double basePrice, String imgUrl) {
        this.id = id;
        this.itemType = itemType;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.imgUrl = imgUrl;
    }

    public ItemCardapioDto(ItemCardapio entity){
        this.id = entity.getId();
        this.itemType = entity.getItemType();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.basePrice = entity.getBasePrice();
        this.imgUrl = entity.getImgUrl();
    }

    @Override
    public String toString() {
        return "ItemCardapioDto{" +
                "id=" + id +
                ", itemType=" + itemType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice=" + basePrice +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

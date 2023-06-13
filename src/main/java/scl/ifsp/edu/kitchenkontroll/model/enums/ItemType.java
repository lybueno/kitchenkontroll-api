package scl.ifsp.edu.kitchenkontroll.model.enums;

public enum ItemType {
    PIZZA(0L),
    DRINK(1L),
    PIZZA_ON_SALE(2L);

    private final Long value;

    ItemType(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}

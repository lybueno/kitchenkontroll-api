package scl.ifsp.edu.kitchenkontroll.model.enums;

public enum Status {
    ONCART(0L),
    REQUESTED(1L),
    PREPARING(2L),
    DONE(3L),
    DELIVERED(4L),
    PAYED(5L);

    private final Long value;

    Status(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}

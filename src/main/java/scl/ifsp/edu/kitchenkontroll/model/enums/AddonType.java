package scl.ifsp.edu.kitchenkontroll.model.enums;

public enum AddonType {

    BORDER("Borda"),
    EXTRA("Extra");

    public final String label;

    private AddonType(String label){
        this.label = label;
    }
}

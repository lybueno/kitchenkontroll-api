package scl.ifsp.edu.kitchenkontroll.model.utils.exceptions;

public class FlavorLimitReachedException extends RuntimeException {
    public FlavorLimitReachedException(String message){
        super(message);
    }
}

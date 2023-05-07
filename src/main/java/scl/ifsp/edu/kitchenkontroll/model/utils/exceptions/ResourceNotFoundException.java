package scl.ifsp.edu.kitchenkontroll.model.utils.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}

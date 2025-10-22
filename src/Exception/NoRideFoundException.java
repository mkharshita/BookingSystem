package Exception;

public class NoRideFoundException extends RuntimeException {
    public NoRideFoundException(String message) {
        super(message);
    }
}

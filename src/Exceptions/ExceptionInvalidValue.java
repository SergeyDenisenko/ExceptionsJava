package Exceptions;

public class ExceptionInvalidValue extends Exception {
    public ExceptionInvalidValue(String message, Exception e) {
        super(message, e);
    }
}

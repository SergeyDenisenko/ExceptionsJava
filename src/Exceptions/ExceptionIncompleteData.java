package Exceptions;

public class ExceptionIncompleteData extends Exception {
    public ExceptionIncompleteData(String message, Exception e) {
        super(message, e);
    }
}

package SMExceptions.naming_exceptions;

public class NumbersFoundException extends WrongInputException {

    public NumbersFoundException(String message) {
        setMessage(message);
    }
}
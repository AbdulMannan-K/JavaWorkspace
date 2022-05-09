package SMExceptions.naming_exceptions;

public class NothingFoundException extends WrongInputException {

    public NothingFoundException() {
        this("No input was detected.");
    }

    public NothingFoundException(String message) {
        setMessage(message);
    }
}

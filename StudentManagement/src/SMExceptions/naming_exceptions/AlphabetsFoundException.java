package SMExceptions.naming_exceptions;

public class AlphabetsFoundException extends WrongInputException {
    public AlphabetsFoundException() {
        this("Alphabets found.");
    }

    private AlphabetsFoundException(String message) {
        super();
        setMessage(message);
    }
}

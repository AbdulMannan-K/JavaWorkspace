package SMExceptions.naming_exceptions;

public class AlphabetsAndSymbolsFoundException extends WrongInputException {

    public AlphabetsAndSymbolsFoundException() {
        this("Alphabets and symbols found.");
    }

    private AlphabetsAndSymbolsFoundException(String message) {
        super();
        setMessage(message);
    }
}

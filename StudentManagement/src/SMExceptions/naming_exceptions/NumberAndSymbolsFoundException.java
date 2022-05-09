package SMExceptions.naming_exceptions;

public class NumberAndSymbolsFoundException extends WrongInputException {

    public NumberAndSymbolsFoundException(String message) {
        setMessage(message);
    }
}

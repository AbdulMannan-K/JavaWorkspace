package SMExceptions.naming_exceptions;

public class SymbolsFoundException extends WrongInputException {

    public SymbolsFoundException() {
        this("Symbol found.");
    }
    public SymbolsFoundException(String message) {
        setMessage(message);
    }
}
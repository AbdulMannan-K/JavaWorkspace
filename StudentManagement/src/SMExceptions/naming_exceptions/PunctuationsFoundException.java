package SMExceptions.naming_exceptions;

public class PunctuationsFoundException extends WrongInputException {
    public PunctuationsFoundException() {
        this("Punctuations were found in Input.");
    }

    private PunctuationsFoundException(String message) {
        super();
        setMessage(message);
    }
}

package SMExceptions.naming_exceptions;

public class IllegalUseOfPunctuation extends WrongInputException {

    public IllegalUseOfPunctuation() {
        this("Illegal use of Punctuation found.");
    }

    public IllegalUseOfPunctuation(String message) {
        this.setMessage(message);
    }
}

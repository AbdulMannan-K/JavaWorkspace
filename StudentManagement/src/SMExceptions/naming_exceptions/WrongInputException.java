package SMExceptions.naming_exceptions;

public class WrongInputException extends Throwable {
    private String message;

    public WrongInputException() {
        this("Wrong Inputs Detected");
    }

    public WrongInputException(String message) {
        super();
        this.message = message;
    }

    public void setMessage(String message) { this.message = message; }

    public String getMessage() {
        return this.message;
    }

    @Override
    public void printStackTrace() {
        System.out.println(message);
    }
}

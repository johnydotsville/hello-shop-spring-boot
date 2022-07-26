package johny.dotsville.hello.core.utils.exceptions;

public class ApplicationException extends RuntimeException {
    public ApplicationException() { }
    public ApplicationException(String message) {
        super(message);
    }
}

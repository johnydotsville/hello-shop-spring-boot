package johny.dotsville.hello.domain.utils.exceptions;

public class ApplicationException extends RuntimeException {
    public ApplicationException() { }
    public ApplicationException(String message) {
        super(message);
    }
}

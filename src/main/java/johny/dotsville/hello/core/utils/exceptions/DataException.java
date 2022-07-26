package johny.dotsville.hello.core.utils.exceptions;

public class DataException extends ApplicationException {
    private final static String defaultMessage = "Данные не найдены";

    public DataException() {
        super(defaultMessage);
    }

    public DataException(String message) {
        super(message);
    }
}
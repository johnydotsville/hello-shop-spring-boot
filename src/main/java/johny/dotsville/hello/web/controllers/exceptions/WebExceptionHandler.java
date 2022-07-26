package johny.dotsville.hello.web.controllers.exceptions;

import johny.dotsville.hello.core.utils.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class WebExceptionHandler extends ResponseEntityExceptionHandler {
    // TODO: сделать в исключениях поля под пользовательскую и админскую ошибки
    @ExceptionHandler(value = { ApplicationException.class })
    protected ResponseEntity<Object> handleExceptions(ApplicationException ex, WebRequest request){
        var response = new ExceptionResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleExceptions(RuntimeException ex, WebRequest request){
//        var response = new ExceptionResponse("Ошибка во время выполнения запроса", LocalDateTime.now());
        var response = new ExceptionResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

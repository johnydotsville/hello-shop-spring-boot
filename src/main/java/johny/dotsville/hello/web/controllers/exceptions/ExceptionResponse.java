package johny.dotsville.hello.web.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private LocalDateTime time;
}

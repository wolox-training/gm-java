package wolox.gmjavatraining.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Path parameter Id and body request Id did not match.")
public class BookIdMismatchException extends Exception {
    public BookIdMismatchException() {
        super();
    }
}

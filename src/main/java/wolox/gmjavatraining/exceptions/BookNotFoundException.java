package wolox.gmjavatraining.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This book does not exist")
public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super();
    }
}

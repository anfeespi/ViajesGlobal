package co.edu.unbosque.viajes_global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotPresentException extends RuntimeException {

    public ElementNotPresentException() {
        super("The element is not present on our database");
    }
}

package co.edu.unbosque.viajes_global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DateException extends RuntimeException{
    public DateException() {
        super("We have problems to parse the Date");
    }
}

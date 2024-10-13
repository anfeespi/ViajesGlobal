package co.edu.unbosque.viajes_global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenderNotFound extends RuntimeException{
    public GenderNotFound() {
        super("The gender is not found");
    }
}

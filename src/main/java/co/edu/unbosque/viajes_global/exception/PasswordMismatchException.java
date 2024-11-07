package co.edu.unbosque.viajes_global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PasswordMismatchException extends Exception{
    public PasswordMismatchException(){
        super("Password mismatch");
    }
}

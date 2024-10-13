package co.edu.unbosque.viajes_global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DocumentTypeNotFound extends RuntimeException {
    public DocumentTypeNotFound() {
        super("The Document Type is not found");
    }
}

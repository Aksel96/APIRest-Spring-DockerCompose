package mx.unam.aragon.ico.is.videojuegos.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HashMap<String,String>> manejoDeRest(ConstraintViolationException ex) {
        HashMap<String,String> respuesta = new HashMap<>();
        respuesta.put("Mensaje", ex.getLocalizedMessage());
        respuesta.put("timestam", LocalDateTime.now().toString());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> manejoDeRest(HttpMessageNotReadableException ex) {
        HashMap<String,String> respuesta = new HashMap<>();
        respuesta.put("Mensaje", ex.getLocalizedMessage());
        respuesta.put("timestam", LocalDateTime.now().toString());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }




}

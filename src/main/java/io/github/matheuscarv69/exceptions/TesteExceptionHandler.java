package io.github.matheuscarv69.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.List;

@ControllerAdvice
public class TesteExceptionHandler {

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<StandardError> businessRuleInvalid(BusinessRuleException e, HttpServletRequest request) {
        String error = "Business Rule error ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(StateCivilException.class)
    public ResponseEntity<StandardError> stateCivilInvalid(StateCivilException e, HttpServletRequest request) {
        String error = "Civil State error ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(SchoolingException.class)
    public ResponseEntity<StandardError> schoolingInvalid(SchoolingException e, HttpServletRequest request) {
        String error = "Schooling error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResidenceException.class)
    public ResponseEntity<StandardError> residenceInvalid(ResidenceException e, HttpServletRequest request) {
        String error = "Residence error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(KinshipException.class)
    public ResponseEntity<StandardError> kinshipInvalid(KinshipException e, HttpServletRequest request) {
        String error = "Kinship error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationsInvalid(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(er -> er.getDefaultMessage())
                .collect(Collectors.toList());

        String error = "Validation error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, "Required fields", request.getRequestURI());
        err.getErrors().addAll(errors);

        return ResponseEntity.status(status).body(err);
    }


}

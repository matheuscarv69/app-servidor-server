package io.github.matheuscarv69.rest.controller;

import io.github.matheuscarv69.exceptions.*;
import io.github.matheuscarv69.rest.ApiErrors;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handle(RuntimeException ex) {
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);

    }

    // pega os errors de validacao
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErrors(errors);

    }

    @ExceptionHandler(BusinessRuleException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleCampoInvalidoException(BusinessRuleException ex) {
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleListIsEmptyException(HttpMessageNotReadableException ex) {
        String mensagemErro = "Código de campo inválido";

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(StateCivilException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleEstadoCivilException(StateCivilException ex) {
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(SchoolingException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleEscolaridadeException(SchoolingException ex) {
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(ResidenceException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleResidenciaException(ResidenceException ex) {
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(KinshipException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleGrauParentescoException(KinshipException ex) {
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }


}

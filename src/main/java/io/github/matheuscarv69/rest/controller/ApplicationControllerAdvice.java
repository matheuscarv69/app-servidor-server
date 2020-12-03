package io.github.matheuscarv69.rest.controller;

import com.fasterxml.jackson.core.JsonParseException;
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

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleCampoInvalidoException(RegraNegocioException ex) {
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(ListIsEmptyException.class)
    @ResponseStatus(OK)
    public ApiErrors handleListIsEmptyException(ListIsEmptyException ex){
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleListIsEmptyException(HttpMessageNotReadableException ex){
        String mensagemErro = "Código de campo inválido";

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(EstadoCivilException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleEstadoCivilException(EstadoCivilException ex){
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(EscolaridadeException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleEscolaridadeException(EscolaridadeException ex){
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(ResidenciaException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleResidenciaException(ResidenciaException ex){
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(GrauParentescoException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleGrauParentescoException(GrauParentescoException ex){
        String mensagemErro = ex.getMessage();

        return new ApiErrors(mensagemErro);
    }

}

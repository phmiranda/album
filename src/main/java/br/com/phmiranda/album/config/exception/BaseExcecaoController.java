/**
 * Project: album
 * User History: nº 999
 * Description: N/A
 * User: Pedro
 */

package br.com.phmiranda.album.config.exception;

import br.com.phmiranda.album.domain.dto.handler.ExcecaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class BaseExcecaoController {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ExcecaoDto> handle(MethodArgumentNotValidException exception) {
        List<ExcecaoDto> excecoes = new ArrayList<>();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        errors.forEach( e-> {
            String messagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ExcecaoDto error = new ExcecaoDto(e.getField(), messagem);
            excecoes.add(error);
        });

        return excecoes;
    }
}

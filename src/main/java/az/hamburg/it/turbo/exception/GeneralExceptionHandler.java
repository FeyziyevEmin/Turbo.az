package az.hamburg.it.turbo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static az.hamburg.it.turbo.exception.ExceptionConstants.UNEXPECTED_EXCEPTION;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorDetails handle(NotFoundException ex) {
        return new ErrorDetails(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorDetails handle(Exception ex) {
        log.error("Exception, " + ex.getMessage());
        return new ErrorDetails(UNEXPECTED_EXCEPTION.getCode(), UNEXPECTED_EXCEPTION.getMessage());
    }
}
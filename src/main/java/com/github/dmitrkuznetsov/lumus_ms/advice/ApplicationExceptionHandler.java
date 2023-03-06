package com.github.dmitrkuznetsov.lumus_ms.advice;

import com.github.dmitrkuznetsov.lumus_ms.dto.ExceptionResponse;
import com.github.dmitrkuznetsov.lumus_ms.exception.NoSuchLedException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public ExceptionResponse handleConstraintViolation(ConstraintViolationException ex) {
    log.debug(
        "Обнаружено исключение нарушения ограничения: {}",
        ex.getConstraintViolations(),
        ex
    );
    return new ExceptionResponse(ex);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoSuchLedException.class)
  public ExceptionResponse handleBusinessException(NoSuchLedException ex) {
    return new ExceptionResponse(ex);
  }
}

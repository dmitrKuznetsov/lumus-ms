package com.github.dmitrkuznetsov.lumus_ms.advice;

import com.github.dmitrkuznetsov.lumus_ms.dto.ExceptionResponse;
import com.github.dmitrkuznetsov.lumus_ms.exception.BadBarcodeException;
import com.github.dmitrkuznetsov.lumus_ms.exception.NoSuchLedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApplicationExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoSuchLedException.class)
  public ExceptionResponse handleBusinessException(NoSuchLedException ex) {
    return new ExceptionResponse(ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BadBarcodeException.class)
  public ExceptionResponse handleBusinessException(BadBarcodeException ex) {
    return new ExceptionResponse(ex);
  }
}

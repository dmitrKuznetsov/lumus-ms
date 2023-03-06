package com.github.dmitrkuznetsov.lumus_ms.exception;

public class BadBarcodeException extends RuntimeException {

  public BadBarcodeException() {
    super("Баркод должен быть положительным числом");
  }
}

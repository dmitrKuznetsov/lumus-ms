package com.github.dmitrkuznetsov.lumus_ms.exception;

public class NoSuchLedException extends RuntimeException {

  public NoSuchLedException(String barcode) {
    super("Нет LED-лампочки с штрих-кодом = " + barcode);
  }
}

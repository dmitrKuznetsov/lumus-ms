package com.github.dmitrkuznetsov.lumus_ms.exception;

public class NoSuchLedException extends RuntimeException {

  public NoSuchLedException(Long barcode) {
    super("Нет LED-лампочки с баркодом = " + barcode);
  }
}

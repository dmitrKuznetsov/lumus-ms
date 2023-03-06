package com.github.dmitrkuznetsov.lumus_ms.dto;

import lombok.Data;

@Data
public class LedInfo<T> {
  private T declared;
  private T measured;

  public LedInfo(T declared, T measured) {
    this.declared = declared;
    this.measured = measured;
  }
}

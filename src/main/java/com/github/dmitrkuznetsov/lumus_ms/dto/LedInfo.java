package com.github.dmitrkuznetsov.lumus_ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LedInfo {
  private String declared;
  private String measured;

  public LedInfo(Integer declared, Integer measured) {
    this.declared = prepareString(declared);
    this.measured = prepareString(measured);
  }

  public LedInfo(Double declared, Double measured) {
    this.declared = prepareString(declared);
    this.measured = prepareString(measured);
  }

  private <T> String prepareString(T data) {
    return data == null ? "-" : data.toString();
  }
}

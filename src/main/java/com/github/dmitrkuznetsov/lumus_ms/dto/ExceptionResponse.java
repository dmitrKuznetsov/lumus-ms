package com.github.dmitrkuznetsov.lumus_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Информация о исключении")
public class ExceptionResponse {

  @Schema(description = "Сообщение")
  private final String message;

  public ExceptionResponse(RuntimeException ex) {
    this.message = ex.getMessage();
  }
}

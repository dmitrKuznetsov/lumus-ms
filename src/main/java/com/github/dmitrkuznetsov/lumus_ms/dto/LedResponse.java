package com.github.dmitrkuznetsov.lumus_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о LED-лампочке")
public class LedResponse {

  @Schema(description = "Фото лампочки")
  private String image;
  @Schema(description = "Модель")
  private String model;
  @Schema(description = "Бренд")
  private String brand;
  @Schema(description = "Рейтинг (0-5)")
  private Double rating;
  @Schema(description = "Срок службы, час")
  private Integer life;
  @Schema(description = "Цена, руб")
  private Double price;
  @Schema(description = "Рабочее напряжение, минимальное, В")
  private String voltage;
  @Schema(description = "Цветовая температура, К")
  private LedInfo<Integer> temp;
  @Schema(description = "Яркость, лм")
  private LedInfo<Integer> brightness;
  @Schema(description = "Мощность, Вт")
  private LedInfo<Double> power;

}

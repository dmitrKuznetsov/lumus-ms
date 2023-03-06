package com.github.dmitrkuznetsov.lumus_ms.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "led")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Led {
  @Id
  @Column(name = "no")
  private Long id;

  @Column(name = "brand")
  private String brand;

  @Column(name = "model")
  private String model;

  @Column(name = "power_l")
  private Double power_l;

  @Column(name = "p")
  private Double p;

  @Column(name = "color_l")
  private Integer color_l;

  @Column(name = "color")
  private Integer color;

  @Column(name = "lm_l")
  private Integer lm_l;

  @Column(name = "lm")
  private Integer lm;

  @Column(name = "barcode")
  private String barcode;

  @Column(name = "rub")
  private Double rub;

  @Column(name = "rating")
  private Double rating;

  @Column(name = "lamp_image")
  private String lamp_image;

  @Column(name = "u")
  private String u;

  @Column(name = "life")
  private Integer life;
}

package com.github.dmitrkuznetsov.lumus_ms.controller;

import com.github.dmitrkuznetsov.lumus_ms.dto.LedResponse;
import com.github.dmitrkuznetsov.lumus_ms.service.LedService;
import com.github.dmitrkuznetsov.lumus_ms.validation.Barcode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/led")
@RequiredArgsConstructor
@Tag(name = "LED-лампочки", description = "Методы для работы с LED-лампочками")
@Validated
public class LedController {

  private final LedService ledService;

  @GetMapping("/barcode/{barcode}")
  @Operation(summary = "Информация о LED-лампочке по его barcode")
  LedResponse findLedByBarcode(@PathVariable("barcode") @Barcode String barcode) {

    return ledService.findLedByBarcode(barcode);
  }
}

package com.github.dmitrkuznetsov.lumus_ms.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BarcodeValidator implements ConstraintValidator<Barcode, String> {

  @Override
  public boolean isValid(String barcode, ConstraintValidatorContext constraintValidatorContext) {

    if (barcode == null || barcode.isBlank())
      return false;

    return barcode.matches("^[0-9]*$");
  }
}

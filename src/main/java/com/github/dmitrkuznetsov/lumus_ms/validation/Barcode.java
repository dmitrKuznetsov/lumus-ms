package com.github.dmitrkuznetsov.lumus_ms.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = BarcodeValidator.class)
@Documented
public @interface Barcode {
  String message() default "Штрих-код должен содержать только цифры";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
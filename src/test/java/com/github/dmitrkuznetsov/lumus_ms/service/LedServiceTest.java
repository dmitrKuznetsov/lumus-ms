package com.github.dmitrkuznetsov.lumus_ms.service;

import com.github.dmitrkuznetsov.lumus_ms.exception.NoSuchLedException;
import com.github.dmitrkuznetsov.lumus_ms.mapper.LedMapper;
import com.github.dmitrkuznetsov.lumus_ms.repository.LedRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;


class LedServiceTest {


  @Test
  public void shouldThrowNoSuchLedException() {
    String barcode = "1212121212";
    LedRepository ledRepository = Mockito.mock(LedRepository.class);
    LedMapper ledMapper = Mockito.mock(LedMapper.class);
    LedService ledService = new LedServiceImpl(ledRepository, ledMapper);
    Mockito.when(ledRepository.findByBarcode(barcode)).thenReturn(Optional.ofNullable(null));

    Assertions.assertThrows(NoSuchLedException.class, () ->
        ledService.findLedByBarcode(barcode)
    );
  }
}
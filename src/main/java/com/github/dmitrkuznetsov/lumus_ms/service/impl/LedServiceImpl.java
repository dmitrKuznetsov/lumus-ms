package com.github.dmitrkuznetsov.lumus_ms.service.impl;

import com.github.dmitrkuznetsov.lumus_ms.dto.LedResponse;
import com.github.dmitrkuznetsov.lumus_ms.exception.NoSuchLedException;
import com.github.dmitrkuznetsov.lumus_ms.mapper.LedMapper;
import com.github.dmitrkuznetsov.lumus_ms.repository.LedRepository;
import com.github.dmitrkuznetsov.lumus_ms.service.LedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LedServiceImpl implements LedService {

  private final LedRepository ledRepository;
  private final LedMapper ledMapper;

  @Override
  public LedResponse findLedByBarcode(Long barcode) {
    return ledMapper.toDto(ledRepository.findByBarcode(barcode).orElseThrow(
        () -> new NoSuchLedException(barcode)
    ));
  }
}

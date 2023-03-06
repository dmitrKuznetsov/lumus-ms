package com.github.dmitrkuznetsov.lumus_ms.service;

import com.github.dmitrkuznetsov.lumus_ms.dto.LedResponse;
import com.github.dmitrkuznetsov.lumus_ms.exception.NoSuchLedException;
import com.github.dmitrkuznetsov.lumus_ms.helper.CSVHelper;
import com.github.dmitrkuznetsov.lumus_ms.mapper.LedMapper;
import com.github.dmitrkuznetsov.lumus_ms.repository.LedRepository;
import com.github.dmitrkuznetsov.lumus_ms.repository.entity.Led;
import com.github.dmitrkuznetsov.lumus_ms.service.LedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LedServiceImpl implements LedService {

  private final LedRepository ledRepository;
  private final LedMapper ledMapper;

  @Override
  public LedResponse findLedByBarcode(String barcode) {

    return ledMapper.toDto(ledRepository.findByBarcode(barcode).orElseThrow(
        () -> new NoSuchLedException(barcode)
    ));
  }
}

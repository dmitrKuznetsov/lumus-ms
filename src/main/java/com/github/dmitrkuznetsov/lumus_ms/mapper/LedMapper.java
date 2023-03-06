package com.github.dmitrkuznetsov.lumus_ms.mapper;

import com.github.dmitrkuznetsov.lumus_ms.dto.LedResponse;
import com.github.dmitrkuznetsov.lumus_ms.repository.entity.Led;

public interface LedMapper {
  LedResponse toDto(Led led);

  Led toEntity(LedResponse dto);
}

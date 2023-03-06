package com.github.dmitrkuznetsov.lumus_ms.mapper;

import com.github.dmitrkuznetsov.lumus_ms.dto.LedInfo;
import com.github.dmitrkuznetsov.lumus_ms.dto.LedResponse;
import com.github.dmitrkuznetsov.lumus_ms.repository.entity.Led;
import org.springframework.stereotype.Component;

@Component
public class LedMapperImpl implements LedMapper {

  @Override
  public LedResponse toDto(Led led) {
    return LedResponse.builder()
        .image("https://lamptest.ru/images/photo/" + led.getLamp_image() + ".jpg")
        .model(led.getModel())
        .brand(led.getBrand())
        .rating(led.getRating())
        .price(led.getRub())
        .voltage(led.getU())
        .life(led.getLife())
        .temp(new LedInfo<>(led.getColor_l(), led.getColor()))
        .brightness(new LedInfo<>(led.getLm_l(), led.getLm()))
        .power(new LedInfo<>(led.getPower_l(), led.getP()))
        .build();
  }

  @Override
  public Led toEntity(LedResponse dto) {
    return null;
  }

}

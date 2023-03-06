package com.github.dmitrkuznetsov.lumus_ms.job;

import com.github.dmitrkuznetsov.lumus_ms.helper.CSVHelper;
import com.github.dmitrkuznetsov.lumus_ms.repository.LedRepository;
import com.github.dmitrkuznetsov.lumus_ms.repository.entity.Led;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SeedDataJob {

    private final LedRepository ledRepository;

    @PostConstruct
    public void seedLedFromCSV() {

        LocalDateTime start = LocalDateTime.now();

        log.info("Начало загрузки записей из CSV файла в базу данных...");

        try (InputStream file = new URL("http://lamptest.ru/led.csv").openStream()) {
            List<Led> leds = CSVHelper.csvToLeds(file);
            ledRepository.deleteAll();
            ledRepository.saveAll(leds);
        } catch (IOException e) {
            log.error("При обработке CSV файла произошла ошибка:" + e.getMessage());
        }

        LocalDateTime end = LocalDateTime.now();

        log.info("Загрузка новых записей в таблицу завершена. Заняло времени: {} с.",
                end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC));
    }
}

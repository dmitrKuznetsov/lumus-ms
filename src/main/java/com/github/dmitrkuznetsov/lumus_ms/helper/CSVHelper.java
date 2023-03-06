package com.github.dmitrkuznetsov.lumus_ms.helper;

import com.github.dmitrkuznetsov.lumus_ms.repository.entity.Led;
import org.apache.commons.csv.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CSVHelper {

  public static List<Led> csvToLeds(InputStream is) throws IOException {

    CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
        .setDelimiter(';')
        .setIgnoreEmptyLines(true)
        .setRecordSeparator('\n')
        .setHeader().setSkipHeaderRecord(true)
        .setNullString("")
        .build();

    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
         CSVParser csvParser = new CSVParser(fileReader, csvFormat)) {

      List<Led> leds = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      for (CSVRecord csvRecord : csvRecords) {
        Led led = Led.builder()
            .id(Long.parseLong(csvRecord.get("no")))
            .brand(csvRecord.get("brand"))
            .model(csvRecord.get("model"))
            .power_l(parse(csvRecord.get("power_l"), Double::valueOf))
            .p(parse(csvRecord.get("p"), Double::valueOf))
            .color_l(parse(csvRecord.get("color_l"), Integer::valueOf))
            .color(parse(csvRecord.get("color"), Integer::valueOf))
            .lm_l(parse(csvRecord.get("lm_l"), Integer::valueOf))
            .lm(parse(csvRecord.get("lm"), Integer::valueOf))
            .barcode(csvRecord.get("barcode"))
            .rub(parse(csvRecord.get("rub"), Double::valueOf))
            .rating(parse(csvRecord.get("rating"), Double::valueOf))
            .lamp_image(csvRecord.get("lamp_image"))
            .u(csvRecord.get("u"))
            .life(parse(csvRecord.get("life"), Integer::valueOf))
            .build();

        leds.add(led);
      }

      return leds;
    }
  }

  private static <T> T parse(String value, Function<String, T> func) {
    if (value == null || value.equals("") || value.equals("-")) {
      return null;
    }

    return func.apply(value);
  }
}
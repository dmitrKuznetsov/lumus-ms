package com.github.dmitrkuznetsov.lumus_ms.service;

import com.github.dmitrkuznetsov.lumus_ms.dto.LedResponse;

public interface LedService {

  LedResponse findLedByBarcode(String barcode);
}

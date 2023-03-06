package com.github.dmitrkuznetsov.lumus_ms.repository;

import com.github.dmitrkuznetsov.lumus_ms.repository.entity.Led;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LedRepository extends JpaRepository<Led, Integer> {

  Optional<Led> findByBarcode(Long barcode);
}

package com.example.pedidos.repository;

import com.example.pedidos.entity.LogError;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogErrorRepository extends JpaRepository<LogError, Long> {
}

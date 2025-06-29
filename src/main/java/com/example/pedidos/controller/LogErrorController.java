package com.example.pedidos.controller;

import com.example.pedidos.entity.LogError;
import com.example.pedidos.repository.LogErrorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/errores")
public class LogErrorController {

    private final LogErrorRepository logErrorRepository;

    public LogErrorController(LogErrorRepository logErrorRepository) {
        this.logErrorRepository = logErrorRepository;
    }

    @GetMapping
    public List<LogError> obtenerErrores() {
        return logErrorRepository.findAll();
    }
}

package com.example.pedidos.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LogError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    private LocalDateTime fecha = LocalDateTime.now();

    public LogError() {}

    public LogError(Long id, String mensaje, LocalDateTime fecha) {
        this.id = id;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}

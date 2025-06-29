package com.example.pedidos.controller;

import com.example.pedidos.entity.Pedido;
import com.example.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return pedidoService.listar();
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevo = pedidoService.guardar(pedido); // ← usamos "guardar", no "crearPedido"
        return ResponseEntity.status(201).body(nuevo);
    }

    @GetMapping("/estado/{estado}")
    public List<Pedido> obtenerPorEstado(@PathVariable String estado) {
        return pedidoService.buscarPorEstado(estado);
    }
}

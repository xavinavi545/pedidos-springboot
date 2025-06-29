package com.example.pedidos.service;

import com.example.pedidos.entity.LogError;
import com.example.pedidos.entity.Pedido;
import com.example.pedidos.repository.LogErrorRepository;
import com.example.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LogErrorRepository logErrorRepository;

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido guardar(Pedido pedido) {
        try {
            return pedidoRepository.save(pedido);
        } catch (Exception e) {
            LogError log = new LogError();
            log.setFecha(LocalDateTime.now());
            log.setMensaje("Error al guardar pedido: " + e.getMessage());
            logErrorRepository.save(log);
            throw e;
        }
    }

    public List<Pedido> buscarPorEstado(String estado) {
        return pedidoRepository.findByEstado(estado);
    }
}

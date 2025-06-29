package com.example.pedidos.repository;

import com.example.pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByEstado(String estado); // ← Agregamos este método de consulta
}

package com.project.microservices.order.Repositories;

import com.project.microservices.order.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

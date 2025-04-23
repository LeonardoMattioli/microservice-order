package com.project.microservices.order.Repositories;

import com.project.microservices.order.models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}

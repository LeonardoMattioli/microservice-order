package com.project.microservices.order.controllers;

import com.project.microservices.order.models.Pedido;
import com.project.microservices.order.services.PedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final RabbitTemplate rabbitTemplate;
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService, RabbitTemplate rabbitTemplate) {
        this.pedidoService = pedidoService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    @PostMapping
    public String creiarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSave = pedidoService.save(pedido);
        rabbitTemplate.convertAndSend("", routingKey, pedidoSave.getDescricao());
        return "Pedido criado com sucesso!";
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }
}

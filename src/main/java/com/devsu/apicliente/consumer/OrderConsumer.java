package com.devsu.apicliente.consumer;

import com.devsu.apicliente.dto.CuentaEvent;
import com.devsu.apicliente.dto.rabbit.ClienteDTO;
import com.devsu.apicliente.dto.rabbit.ClienteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Value("${rabbitmq.exchange.cliente.name}")
    private String exchange;

    @Value("${rabbitmq.binding.routing.cliente.key}")
    private String orderRoutingKey;


    private RabbitTemplate rabbitTemplate;
    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.cuenta.name}")
    public void consume(CuentaEvent event){
        LOGGER.info(String.format("Order event received => %s", event.toString()));

        // save order event data in database


        // Envio respuesta del cliente

        ClienteEvent eventCliente = new ClienteEvent();
        eventCliente.setStatus("PENDING");
        eventCliente.setMessage("Order is in pending status");
        eventCliente.setCliente(ClienteDTO.builder()
                        .nombre("PABLO")
                        .dni(494595)
                        .direccion("cfkfkfkf")
                .build());
        rabbitTemplate.convertAndSend(exchange, orderRoutingKey, eventCliente);



    }
}

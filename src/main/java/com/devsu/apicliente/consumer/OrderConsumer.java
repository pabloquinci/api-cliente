package com.devsu.apicliente.consumer;

import com.devsu.apicliente.dto.CuentaEvent;
import com.devsu.apicliente.dto.rabbit.ClienteDTO;
import com.devsu.apicliente.dto.rabbit.ClienteEvent;
import com.devsu.apicliente.exception.UserNotFoundExcdeption;
import com.devsu.apicliente.model.Cliente;
import com.devsu.apicliente.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Value("${rabbitmq.exchange.cliente.name}")
    private String exchange;

    @Value("${rabbitmq.binding.routing.cliente.key}")
    private String orderRoutingKey;

    @Autowired
    private final ClienteRepository clienteRepository;

    public OrderConsumer(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Autowired
    private RabbitTemplate rabbitTemplate;
    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.cuenta.name}")
    public void consume(CuentaEvent event){
        ClienteEvent eventCliente = new ClienteEvent();

        try{

        LOGGER.info(String.format("Order event received => %s", event.toString()));

        // save order event data in database

        Cliente clienteUpdate=this.clienteRepository.findByDni(event.getCuenta().getDni())
                .orElseThrow(()-> new UserNotFoundExcdeption());

        // Envio respuesta del client
        eventCliente.setStatus("SENDING");
        eventCliente.setMessage("Enviando info usuario");
        eventCliente.setCliente(ClienteDTO.builder()
                        .nombre(clienteUpdate.getNombre())
                        .dni(clienteUpdate.getDni().intValue())
                        .direccion(clienteUpdate.getDireccion())
                .build());
        rabbitTemplate.convertAndSend(exchange, orderRoutingKey, eventCliente);

        }
        catch(Exception ex){
            eventCliente.setStatus("ERROR");
            eventCliente.setMessage("Enviando error usuario");
            rabbitTemplate.convertAndSend(exchange, orderRoutingKey, eventCliente);

        }

    }
}

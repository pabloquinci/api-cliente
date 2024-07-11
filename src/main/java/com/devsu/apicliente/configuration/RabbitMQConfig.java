package com.devsu.apicliente.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {



    //Configuro la cola donde responde los datos del cliente

    @Value("${rabbitmq.queue.cliente.name}")
    private String clienteQueue;

    @Value("${rabbitmq.exchange.cliente.name}")
    private String clienteExchange;

    @Value("${rabbitmq.binding.routing.cliente.key}")
    private String clienteRoutingKey;

    @Bean
    public Queue orderQueue(){
        return new Queue(clienteQueue);
    }


    // message converter
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    // configure RabbitTemplate
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    // spring bean for queue - order queue

    // spring bean for exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(clienteExchange);
    }

    // spring bean for binding between exchange and queue using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(orderQueue())
                .to(exchange())
                .with(clienteRoutingKey);
    }




}

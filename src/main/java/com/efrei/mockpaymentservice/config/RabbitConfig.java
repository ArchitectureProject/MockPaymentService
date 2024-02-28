package com.efrei.mockpaymentservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    Queue queue() {
        return new Queue("processedPaymentQueue", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("paymentProcessedServiceExchange");
    }

    @Bean
    Binding binding(Queue paymentProcessingQueue, TopicExchange paymentServiceExchange) {
        return BindingBuilder.bind(paymentProcessingQueue).to(paymentServiceExchange).with("payment.#");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
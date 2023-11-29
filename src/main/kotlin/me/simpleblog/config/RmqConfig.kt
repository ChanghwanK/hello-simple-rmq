package me.simpleblog.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RmqConfig(
    private val connectionFactory: ConnectionFactory,
) {

    @Bean
    fun rabbitmqTemplate(messageConverter: MessageConverter): RabbitTemplate =
        RabbitTemplate(connectionFactory).apply {
            setExchange("me.working")
            this.messageConverter = messageConverter
        }

    @Bean
    fun jackson2JsonMessageConverter(objectMapper: ObjectMapper) = Jackson2JsonMessageConverter(objectMapper)
}

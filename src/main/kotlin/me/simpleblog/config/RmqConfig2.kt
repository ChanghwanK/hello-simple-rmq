package me.simpleblog.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean

// @Configuration
class RmqConfig2(
    private val connectionFactory: ConnectionFactory,
) {

    @Bean
    fun rabbitmqTemplate(
        messageConverter: MessageConverter,
    ): RabbitTemplate =
        RabbitTemplate(connectionFactory).apply {
            setExchange("amq.direct")
            this.messageConverter = messageConverter
        }

    @Bean
    fun messageConverter(
        objectMapper: ObjectMapper,
    ): MessageConverter {
        return Jackson2JsonMessageConverter(objectMapper)
    }
}

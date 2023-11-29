package me.simpleblog.handler

import me.simpleblog.message.HelloMessage
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class GlobalMessageHandler {

    @RabbitListener(queues = ["me.working.queue"])
    fun defaultChanghwanQueueHandler(message: HelloMessage, defaultMessage: Message) {
//        defaultMessage.body
        throw RuntimeException("error")
    }

    @RabbitListener(queues = ["me.working.dead-queue"])
    fun errorHandling(message: Message) {
        val headers: Map<String, Any> = message.getMessageProperties().getHeaders()
        val retriesHeader = headers["x-retries"] as Int?

        println(retriesHeader)
    }
}

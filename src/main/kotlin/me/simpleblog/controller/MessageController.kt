package me.simpleblog.controller

import me.simpleblog.message.HelloMessage
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class MessageReq(
    val message: String,
)

fun MessageReq.toHelloMessage(): HelloMessage {
    return HelloMessage(this.message)
}

@RestController
class MessageController(
    private val rabbitmqTemplate: RabbitTemplate,
) {

    @PostMapping("/api/rmq/message")
    fun message(@RequestBody messageReq: MessageReq) {
        val routeKey = "working"
        rabbitmqTemplate.convertAndSend(routeKey, messageReq.toHelloMessage())
    }
}

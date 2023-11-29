package me.simpleblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleBlogWithRmqApplication

fun main(args: Array<String>) {
    runApplication<SimpleBlogWithRmqApplication>(*args)
}

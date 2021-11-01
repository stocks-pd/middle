package com.example


import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.websocket.*
import java.time.Duration


fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        install(WebSockets)
        {
            pingPeriod = Duration.ofSeconds(15)
            timeout = Duration.ofSeconds(15)
            maxFrameSize = Long.MAX_VALUE
            masking = false
        }
        configureRouting()
        configureSerialization()
        configureTemplating()
        configureHTTP()
        configureSecurity()

    }.start(wait = true)

}


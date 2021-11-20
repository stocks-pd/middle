package com.example.application

import com.example.API.keyAutoselection
import com.example.application.configs.configureRouting
import com.example.application.configs.configureSerialization
import com.example.application.configs.configureDataBase
import com.example.application.configs.configureHTTP
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureRouting()
        configureSerialization()
        configureHTTP()
        configureDataBase()
        keyAutoselection()
    }.start(wait = true)
}


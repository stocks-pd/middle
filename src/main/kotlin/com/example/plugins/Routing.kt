package com.example.plugins

import com.example.routes.registercontractRoutes
import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.delay

fun Application.configureRouting() {

    routing {
        get("/") {
                call.respondText("Hello")
            }
        webSocket("/echo") {
            println("onConnect")
            var received = ""
            try {
                for (frame in incoming){
                    val text = (frame as Frame.Text).readText()
                    println("onMessage")
                    received += text
                    outgoing.send(Frame.Text(text))
                    outgoing.send(Frame.Text(received))
                }
            } catch (e: ClosedReceiveChannelException) {
                println("onClose ${closeReason.await()}")
            } catch (e: Throwable) {
                println("onError ${closeReason.await()}")
                e.printStackTrace()
            }
        }
        webSocket("/data") {
            while (true) {
                send(Frame.Text("Howdy"))
                delay(5000)
            }
        }
       }


    registercontractRoutes()
}

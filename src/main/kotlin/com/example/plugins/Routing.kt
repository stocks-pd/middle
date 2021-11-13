package com.example.plugins

import com.example.routes.FavorsRouting
import com.example.routes.SearchRouting
import com.example.routes.StocksRouting

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello")
        }
    }
    routing {
        FavorsRouting()
        SearchRouting()
        StocksRouting()
    }
}

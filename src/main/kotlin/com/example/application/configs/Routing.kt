package com.example.application.configs

import com.example.as_example.search.searchRouting

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
//        FavorsRouting()
//        StocksRouting()

        searchRouting()
    }
}

package com.example.routes

import com.example.API.search_stock
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.SearchRouting() {
    route("/search") {
        get("{symbol}") {
            val symbol = call.parameters["symbol"] ?: return@get
            val search = search_stock("$symbol")
            print(search)
            call.respond(search)
            //call.respond(Stock1)
        }
    }
}
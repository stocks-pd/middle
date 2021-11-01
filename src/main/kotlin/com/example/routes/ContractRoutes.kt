package com.example.routes

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.contractRouting() {
    route("/favors") {
        get("{symbol}") {
            val symbol = call.parameters["symbol"] ?: return@get
            val status = if (symbol == "TSLA") {
                "OK"
            } else {
                "NOT OK"
            }
            call.respond(status)
        }
    }
    route("/favors") {
        post{
            val Param = call.receive<Filters>()
            print(Param)
            val Filters_Sort = mapOf("Filters" to Param)
            print(Filters_Sort)
            val Stock1_Difference = Difference(2, 1, true, "DAY")
            val Stock1_Price = Price(123.2, Stock1_Difference, Stock1_Difference)
            val Stock1 = Stock("AAPL", "APPLE", "URL", "stock", Stock1_Price)
            print(Stock1)
            call.respond(Stock1)
        }
    }
    route("/stocks") {
        post{
            val Param = call.receive<Filters>()
            print(Param)
            val Filters_Sort = mapOf("Filters" to Param)
            print(Filters_Sort)
            val Stock1_Difference = Difference(2, 1, true, "DAY")
            val Stock1_Price = Price(123.2, Stock1_Difference, Stock1_Difference)
            val Stock1 = Stock("AAPL", "APPLE", "URL", "stock", Stock1_Price)
            print(Stock1)
            call.respond(Stock1)
        }
    }
    route("/search") {
        get("{symbol}"){
            val symbol = call.parameters["symbol"] ?: return@get
            val Stock1_Difference = Difference(2, 1, true, "DAY")
            val Stock1_Price = Price(123.2, Stock1_Difference, Stock1_Difference)
            val Stock1 = Stock(symbol, "APPLE", "URL", "stock", Stock1_Price)
            print(Stock1)
            call.respond(Stock1)
        }
    }
    route("/favors_delete") {
        get("{symbol}"){
            val symbol = call.parameters["symbol"] ?: return@get
            val Stock1_Difference = Difference(2, 1, true, "DAY")
            val Stock1_Price = Price(123.2, Stock1_Difference, Stock1_Difference)
            val Stock1 = Stock(symbol, "APPLE", "URL", "stock", Stock1_Price)
            print(Stock1)
            call.respond(Stock1)

            val status = if (symbol == "APPL") {
                "OK"
            } else {
                "NOT OK"
            }
            call.respond(status)
        }
    }
}
fun Application.registercontractRoutes()
{
    routing {
        contractRouting()
    }
}



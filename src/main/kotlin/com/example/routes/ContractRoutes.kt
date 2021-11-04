package com.example.routes

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import com.example.database.add_favorites
import com.example.database.delete_favorites
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction


fun Route.contractRouting() {



    route("/favors") {
        get("{symbol}") {
            Database.connect(
                url = "jdbc:postgresql://localhost:5432/stonks",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "123"
            )
            var res: Boolean? = false
            val symbol = call.parameters["symbol"] ?: return@get
            transaction {
                addLogger(StdOutSqlLogger)
                res = add_favorites("$symbol")
            }
            val status = if (res == true) {
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
            Database.connect(
                url = "jdbc:postgresql://localhost:5432/stonks",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "123"
            )
            var res: Boolean? = false
            val symbol = call.parameters["symbol"] ?: return@get
            transaction {
                addLogger(StdOutSqlLogger)
                res = delete_favorites("$symbol")
            }
            val status = if (res == true) {
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



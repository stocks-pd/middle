package com.example.routes


import com.example.API.search_stock
import com.example.dataClasses.FiltersClass.Filter
import com.example.database.add_favorites
import com.example.database.delete_favorites
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction


fun Route.FavorsRouting() {

    route("/favors") {
        put("{symbol}") {
            Database.connect(
                url = "jdbc:postgresql://localhost:5432/stonks",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "123"
            )
            var res: Boolean? = false
            val symbol = call.parameters["symbol"] ?: return@put
            transaction {
                addLogger(StdOutSqlLogger)
                res = add_favorites("$symbol")
            }
            val status = if (res == true) {
                "SUCCESSFULLY"
            } else {
                "ERROR"
            }
            call.respond(status)
        }
    }
    route("/favors") {
        post {
            //------------------------------
            val FiltersAndParams = call.receive<Filter>()
            print(FiltersAndParams)
            //val testRes = postFavors(param)
            //------------------------------
            val search = search_stock("TSLA")
            // val Stock1_Difference = Difference(2, 1, true, "DAY")
            //val Stock1_Price = Price(123.2, Stock1_Difference, Stock1_Difference)
            //val Stock1 = Stock("AAPL", "APPLE", "URL", "stock", Stock1_Price)
            //print(Stock1)
            //call.respond(Stock1)
            //print(search)
            call.respond(FiltersAndParams)
        }
    }
    route("/favors") {
        delete("{symbol}") {
            Database.connect(
                url = "jdbc:postgresql://localhost:5432/stonks",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "123"
            )
            var res: Boolean? = false
            val symbol = call.parameters["symbol"] ?: return@delete
            transaction {
                addLogger(StdOutSqlLogger)
                res = delete_favorites("$symbol")
            }
            val status = if (res == true) {
                "SUCCESSFULLY"
            } else {
                "ERROR"
            }
            call.respond(status)
        }
    }
}



package com.example.favorites.delete

import com.example.database.delete_favorites
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.deleteFavorsRouting() {
    route("/favors") {
        delete("{symbol}") {
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
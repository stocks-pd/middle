package com.example.favorites.put

import com.example.API.postFavors
import com.example.database.add_favorites
import com.example.database.delete_favorites
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction


fun Route.putFavorsRouting() {

    route("/favors") {
        put("{symbol}") {
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


}



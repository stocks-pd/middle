//package com.example.routes
//
//
//import com.example.API.postStocks
//import com.example.API.search_stock
//import com.example.API.postFavors
//import com.example.dataClasses.FiltersClass.Filter
//import com.example.database.add_favorites
//import com.example.database.delete_favorites
//import io.ktor.application.*
//import io.ktor.request.*
//import io.ktor.response.*
//import io.ktor.routing.*
//import org.jetbrains.exposed.sql.Database
//import org.jetbrains.exposed.sql.StdOutSqlLogger
//import org.jetbrains.exposed.sql.addLogger
//import org.jetbrains.exposed.sql.transactions.transaction
//
//
//fun Route.FavorsRouting() {
//
//    route("/favors") {
//        put("{symbol}") {
//            var res: Boolean? = false
//            val symbol = call.parameters["symbol"] ?: return@put
//            transaction {
//                addLogger(StdOutSqlLogger)
//                res = add_favorites("$symbol")
//            }
//            val status = if (res == true) {
//                "SUCCESSFULLY"
//            } else {
//                "ERROR"
//            }
//            call.respond(status)
//        }
//    }
//    route("/favors") {
//        post {
//            //------------------------------
//            val FiltersAndParams = call.receive<Filter>()
//            print(FiltersAndParams)
//            val favors = postFavors()
//            call.respond(favors)
//        }
//    }
//    route("/favors") {
//        delete("{symbol}") {
//            var res: Boolean? = false
//            val symbol = call.parameters["symbol"] ?: return@delete
//            transaction {
//                addLogger(StdOutSqlLogger)
//                res = delete_favorites("$symbol")
//            }
//            val status = if (res == true) {
//                "SUCCESSFULLY"
//            } else {
//                "ERROR"
//            }
//            call.respond(status)
//        }
//    }
//}
//
//

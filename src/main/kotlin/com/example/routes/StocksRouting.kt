package com.example.routes
//
//import com.example.API.postStocks
//import com.example.dataClasses.FiltersClass.Filter
//import io.ktor.application.*
//import io.ktor.request.*
//import io.ktor.response.*
//import io.ktor.routing.*
//
//fun Route.StocksRouting() {
//    route("/stocks") {
//        post {
//            val FiltersAndParams = call.receive<Filter>()
//            val catalogStocks = postStocks()
//            call.respond(catalogStocks)
//        }
//    }
//}
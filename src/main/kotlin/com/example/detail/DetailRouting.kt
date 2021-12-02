package com.example.detail

import com.example.common.utils.Status
import com.example.common.utils.badRequest
import com.example.detail.use_cases.DetailStockUseCase
import com.example.search.use_cases.SearchUseCase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.detailRouting() {

    route("/detail") {

        get("/{symbol}") {
            try {
                val ticker = call.parameters["symbol"] ?: return@get call.badRequest()

                val response = DetailStockUseCase().execute(ticker)
                call.respond(response)

            } catch (t: Throwable) {
                call.respond(
                    Status.exception(t)
                )
            }
        }
    }
}
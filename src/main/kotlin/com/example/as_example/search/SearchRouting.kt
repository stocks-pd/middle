package com.example.as_example.search

import com.example.as_example.common.utils.Status
import com.example.as_example.common.utils.badRequest
import com.example.as_example.search.use_cases.SearchUseCase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.searchRouting() {

    route("/search") {

        get("/{symbol}") {
            try {
                val ticker = call.parameters["symbol"] ?: return@get call.badRequest()

                val response = SearchUseCase().execute(ticker)
                call.respond(response)

            } catch (t: Throwable) {
                call.respond(
                    Status.exception(t)
                )
            }
        }
    }
}
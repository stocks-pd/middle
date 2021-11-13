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
            try { // все роутинги нужно оборачивать в try/catch тк может быть эксепшн,
                  // если не оборачивать то сервак упадет

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
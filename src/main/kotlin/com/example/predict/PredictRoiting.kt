package com.example.predict

import com.example.common.utils.Status
import com.example.common.utils.badRequest
import com.example.predict.use_cases.PredictUseCase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.predictRouting() {

    route("/predict") {

        get("/{ticker}/{periods}") {
            try {
                val ticker = call.parameters["ticker"] ?: return@get call.badRequest()
                val periods = call.parameters["periods"] ?: return@get call.badRequest()
                val respond = PredictUseCase().getPredict(ticker, periods)
                call.respond(respond)

            } catch (t: Throwable) {
                call.respond(
                    Status.exception(t)
                )
            }
        }
    }
}

package com.example.as_example.common.utils

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

suspend fun ApplicationCall.badRequest() {
    respond(HttpStatusCode.BadRequest)
}
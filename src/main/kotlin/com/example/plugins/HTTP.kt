package com.example.plugins

import io.ktor.http.*
import io.ktor.features.*
import io.ktor.application.*


fun Application.configureHTTP() {
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Post)///
        method(HttpMethod.Get)//
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.AccessControlAllowOrigin)//
        //header("MyCustomHeader")
        //allowCredentials = true чтобы можно было отправлять учетые данные
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

}

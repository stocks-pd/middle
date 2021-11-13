package com.example.as_example.common

import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
// это клиент который должен использоваться для всех запросов к api
val applicationHttpClient = HttpClient(Apache) {
    engine {
        followRedirects = true
        socketTimeout = 10_000
        connectTimeout = 10_000
        connectionRequestTimeout = 20_000
    }

    defaultRequest {
        url {
            host = NetworkConstants.FMP_HOST
        }
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.BODY
    }

    install(JsonFeature) {
        serializer = KotlinxSerializer(
            kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
        )
    }
}
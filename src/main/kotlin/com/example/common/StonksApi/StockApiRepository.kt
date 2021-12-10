package com.example.common.StonksApi

import com.example.common.NetworkConstants
import com.example.common.StonksApi.models.PredictResponse
import com.example.common.applicationHttpClient
import com.example.predict.models.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import io.ktor.util.*
import io.ktor.util.url
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.URL
import kotlin.text.get

object StockApiRepository {

    private const val DEFAULT_SEARCH_LIMIT = 100
    private const val DEFAULT_EXCHANGE = "NASDAQ"

    suspend fun predict(ticker: String, period: String): List<PredictResponse> {
//        return applicationHttpClient.get {
//            url {
//                host = NetworkConstants.DS_HOST
//                path("/predict?ticker=$ticker&periods=$period")
//            }
//        }
        var result = URL("http://127.0.0.1:8000/predict?ticker=TSLA&periods=MONTH").readText()
        val obj = Json.decodeFromString<List<PredictResponse>>(result)
        return obj

        }
    }


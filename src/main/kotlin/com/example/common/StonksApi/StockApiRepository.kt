package com.example.common.StonksApi

import com.example.common.StonksApi.models.PredictResponse
import com.example.predict.models.*

object StockApiRepository {

    private const val DEFAULT_SEARCH_LIMIT = 100
    private const val DEFAULT_EXCHANGE = "NASDAQ"

    suspend fun predict(ticker: String, period: String): List<PredictResponse> {
        return listOf(
            PredictResponse(123.0, "sfsdf", 123.5, 4342.0, 324.5),
            PredictResponse(124.0, "dfg", 126.5, 4362.0, 3324.5)
        )
//        return applicationHttpClient.get {
//            url {
//                host = NetworkConstants.FMP_HOST
//                path("/profile/$ticker")
//                parameter(NetworkConstants.Parameters.API_KEY, NetworkConstants.API_KEY_VALUE)
//            }
//        }
    }


}
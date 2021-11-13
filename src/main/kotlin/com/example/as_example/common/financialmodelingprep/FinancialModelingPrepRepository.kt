package com.example.as_example.common.financialmodelingprep

import com.example.as_example.common.NetworkConstants
import com.example.as_example.common.applicationHttpClient
import com.example.as_example.common.financialmodelingprep.models.QuoteResponse
import com.example.as_example.common.financialmodelingprep.models.SearchResponse
import io.ktor.client.request.*

object FinancialModelingPrepRepository {

    private const val DEFAULT_SEARCH_LIMIT = 100
    private const val DEFAULT_EXCHANGE = "NASDAQ"

    suspend fun search(input: String): List<SearchResponse> = applicationHttpClient
        .get {
            url {
                host = NetworkConstants.FMP_HOST
                path("/search")
                parameter(NetworkConstants.Parameters.QUERY, input)
                parameter(NetworkConstants.Parameters.EXCHANGE, DEFAULT_EXCHANGE)
                parameter(NetworkConstants.Parameters.LIMIT, DEFAULT_SEARCH_LIMIT)
                parameter(NetworkConstants.Parameters.API_KEY, NetworkConstants.API_KEY_VALUE)
            }
        }

    fun image(ticker: String) = "https://financialmodelingprep.com/image-stock/$ticker.png"

    suspend fun price(ticker: String): QuoteResponse? = applicationHttpClient
        .get<List<QuoteResponse>> {
            url {
                host = NetworkConstants.FMP_HOST
                path("/quote/$ticker")
                parameter(NetworkConstants.Parameters.API_KEY, NetworkConstants.API_KEY_VALUE)
            }
        }
        .firstOrNull()
}
package com.example.common.financialmodelingprep

import com.example.common.NetworkConstants
import com.example.common.applicationHttpClient
import com.example.common.financialmodelingprep.models.QuoteResponse
import com.example.common.financialmodelingprep.models.SearchResponse
import io.ktor.client.request.*
 /*
    в этом объекте нужно будет писать все запросы к FMP. если добавится еще какое-то api,
    значит нужно будет создать еще один репозиторий.
    для базы данных тоже нужно будет создать отдельный репозиторий, если будет много таблиц, то мб
    даже под каждую таблицу
  */
object FinancialModelingPrepRepository {

    private const val DEFAULT_SEARCH_LIMIT = 100
    private const val DEFAULT_EXCHANGE = "NASDAQ"

    suspend fun search(input: String): List<SearchResponse> {
        return applicationHttpClient.get {
                url {
                    host = NetworkConstants.FMP_HOST
                    path("/search")
                    parameter(NetworkConstants.Parameters.QUERY, input)
                    parameter(NetworkConstants.Parameters.EXCHANGE, DEFAULT_EXCHANGE)
                    parameter(NetworkConstants.Parameters.LIMIT, DEFAULT_SEARCH_LIMIT)
                    parameter(NetworkConstants.Parameters.API_KEY, NetworkConstants.API_KEY_VALUE)
                }
            }
    }
     
    fun image(ticker: String) = "https://financialmodelingprep.com/image-stock/$ticker.png"

    suspend fun price(ticker: String): QuoteResponse? {
        return applicationHttpClient
            .get<List<QuoteResponse>> {
                url {
                    host = NetworkConstants.FMP_HOST
                    path("/quote/$ticker")
                    parameter(NetworkConstants.Parameters.API_KEY, NetworkConstants.API_KEY_VALUE)
                }
            }
            .firstOrNull()
    }
}
package com.example.common

import com.example.API.setApiKey
object NetworkConstants {
    const val FMP_HOST = "financialmodelingprep.com/api/v3"
    var API_KEY_VALUE = setApiKey()

    object Parameters {
        const val QUERY = "query"
        const val LIMIT = "limit"
        const val EXCHANGE = "exchange"
        const val API_KEY = "apikey"
    }
}
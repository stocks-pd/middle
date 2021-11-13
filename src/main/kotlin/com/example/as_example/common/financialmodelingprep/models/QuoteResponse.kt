package com.example.as_example.common.financialmodelingprep.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteResponse(
    @SerialName("symbol") val ticker: String? = null,
    @SerialName("name") val company: String? = null,
    @SerialName("open") val currentPrice: Double? = null,
    @SerialName("previousClose") val previousPrice: Double? = null,
    @SerialName("changesPercentage") val changesPercentage: Double? = null,
)

package com.example.common.financialmodelingprep.models

import kotlinx.serialization.*


@Serializable
data class DetailStockResponce(
    @SerialName("ceo") val ceo: String? = null,
    @SerialName("companyName") val companyName: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("industry") val industry: String? = null,
    @SerialName("sector") val sector: String? = null,
    @SerialName("symbol") val symbol: String? = null,
    @SerialName("website") val website: String? = null
)
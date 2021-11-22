package com.example.common.financialmodelingprep.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("symbol") val ticker: String? = null,
    @SerialName("name") val company: String? = null, // нужно задавать чему будет равно поле если не придет информация
    @SerialName("currency") val currency: String? = null, // это нужно делать для всех моделей которые приходят от api
)

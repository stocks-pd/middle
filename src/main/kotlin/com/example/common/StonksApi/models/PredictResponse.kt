package com.example.common.StonksApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PredictResponse(
    @SerialName("ds") val ds: Double,
    @SerialName("yhat") val yhat: Double,
    @SerialName("yhat_lower") val yhat_lower: Double,
    @SerialName("yhat_upper") val yhat_upper: Double,
    @SerialName("risk") val risk: Double,
)

package com.example.dataClasses.FiltersClass
import kotlinx.serialization.Serializable

@Serializable
data class Filters(
    val filter1: Int,
    val filter2: Int,
    val filter3: Int,
    val filter4: Int,
    val filter5: Int,
    val filter6: Int
)
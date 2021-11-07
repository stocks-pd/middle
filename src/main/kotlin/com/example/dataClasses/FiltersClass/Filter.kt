package com.example.dataClasses.FiltersClass

import kotlinx.serialization.Serializable

@Serializable

data class Filter(
    val filters: Filters,
    val sort: String
)
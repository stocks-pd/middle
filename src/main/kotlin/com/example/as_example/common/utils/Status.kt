package com.example.as_example.common.utils

import kotlinx.serialization.Serializable

@Serializable
data class Status(
    val code: String,
    val message: String? = null,
    val exceptionName: String? = null
) {
    companion object {

        fun exception(throwable: Throwable) {
            Status(
                code = "ERROR",
                message = throwable.message,
                exceptionName = throwable::class.simpleName
            )
        }

        val ok = Status("OK")
    }
}

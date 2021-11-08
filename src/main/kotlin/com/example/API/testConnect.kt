package com.example.API

import java.net.URL

class Request(private val url: String) {
    fun run() {
        val forecastJson = URL(url).readText()
    }
}

fun main() {
    val url = "https://financialmodelingprep.com/api/v3/quote/RUBUSD?apikey=$apikey"
    val forecastJson = URL(url).readText()
    print(forecastJson)
}


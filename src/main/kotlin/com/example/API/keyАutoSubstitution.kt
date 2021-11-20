package com.example.API

import io.ktor.application.*
import java.net.URL

class Request(private val url: String) {
    fun run() {
        val forecastJson = URL(url).readText()
    }
}

fun setApiKey(): String {
    var apikey = keyArray[0]
    var trig = 0
    var i = -1
    val error = "Error Message"
    while (trig !=1) {
        try {
            i++
            val url = "https://financialmodelingprep.com/api/v3/quote/RUBUSD?apikey=$apikey"
            val forecastJson = URL(url).readText()
            if (error in forecastJson) {
                print("Api key is invalid: $apikey")
                apikey = keyArray[i]
                print(" Error $apikey  ")
            } else {
                print("OK: ")
                trig = 1
                print(" $apikey  ")
            }
        } catch (e: java.io.IOException) {
            print(e.toString())
            apikey = keyArray[i]
            print(" Error $apikey  ")

        }
    }
    print("Active: $apikey" )
    return apikey
}

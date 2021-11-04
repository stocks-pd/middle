package com.example.API

import java.net.URL

class Request(private val url: String)
{
    fun run()
    {
        val forecastJson = URL(url).readText()
    }
}

fun search_stock(_symbol:String): String {
    val symbol = _symbol
    val url = "https://financialmodelingprep.com/api/v3/quote/$symbol?apikey=9821c9be1c0c2f131a182998a4c5ff68"
    val forecastJson = URL(url).readText()
    print(forecastJson)
    return forecastJson
}

fun main()
{
    val url = "https://financialmodelingprep.com/api/v3/quote/RUBUSD?apikey=9821c9be1c0c2f131a182998a4c5ff68"

    val forecastJson = URL(url).readText()
    print(forecastJson)

}


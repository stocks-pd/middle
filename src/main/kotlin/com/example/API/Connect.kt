package com.example.API

import java.net.URL
import com.google.gson.Gson
import com.example.routes.ForecastJson1Class.*
import com.example.routes.ForecastJson2Class.*
import com.example.routes.StockClass.Difference
import com.example.routes.StockClass.Price
import com.example.routes.StockClass.Stock

class Request(private val url: String) {
    fun run() {
        val forecastJson = URL(url).readText()
    }
}

fun search_stock(_symbol: String): String {
    val symbol = _symbol
    var url =
        "https://financialmodelingprep.com/api/v3/quote/$symbol?apikey=9821c9be1c0c2f131a182998a4c5ff68" //symbol value changesPercentage change
    val JsonIN1 = URL(url).readText()
    url = "https://financialmodelingprep.com/api/v3/stock/list?apikey=9821c9be1c0c2f131a182998a4c5ff68" //type
    //val JsonIN3 = URL(url).readText()
    url =
        "https://financialmodelingprep.com/api/v3/profile/$symbol?apikey=9821c9be1c0c2f131a182998a4c5ff68" //currensy company imageUrl
    val JsonIN2 = URL(url).readText()
    val gson = Gson()

    if (JsonIN1 == "" || JsonIN2 == "") {
        return "NOT FOUND"
    } else {
        //==========================================================================================
        val Stock1_Difference = Difference(2.0, 1.0, true, "DAY")
        val Stock1_Price = Price(123.2, "USD", Stock1_Difference)
        val Stock1 = Stock(symbol, "APPLE", "URL", "stock", Stock1_Price)
        //==========================================================================================
        val ArrayJson1 = gson.fromJson(JsonIN1, forecastJson1::class.java)
        val ObjectJsonIN1 = ArrayJson1[0]
        Stock1.symbol = ObjectJsonIN1.symbol
        Stock1_Price.value = ObjectJsonIN1.price
        Stock1_Difference.changesPercentage = ObjectJsonIN1.changesPercentage
        Stock1_Difference.change = ObjectJsonIN1.change
        //==========================================================================================
        val ArrayJson2 = gson.fromJson(JsonIN2, ForecastJson2::class.java)
        val ObjectJsonIN2 = ArrayJson2[0]
        Stock1_Price.currency = ObjectJsonIN2.currency
        Stock1.company = ObjectJsonIN2.companyName
        Stock1.image = ObjectJsonIN2.image
        if (Stock1_Difference.changesPercentage >= 0) {
            Stock1_Difference.isGrows = true
        } else {
            Stock1_Difference.isGrows = false
        }
        //==========================================================================================
        var jsonString = gson.toJson(Stock1)
        print(jsonString)
        return jsonString
    }

}

fun main() {
    val url = "https://financialmodelingprep.com/api/v3/quote/RUBUSD?apikey=9821c9be1c0c2f131a182998a4c5ff68"

    val forecastJson = URL(url).readText()
    print(forecastJson)

}


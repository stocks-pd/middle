package com.example.API

import com.example.dataClasses.ForecastJson1Class.forecastJson1
import com.example.dataClasses.ForecastJson2Class.ForecastJson2
import com.example.dataClasses.StockClass.Difference
import com.example.dataClasses.StockClass.Price
import com.example.dataClasses.StockClass.Stock
import com.google.gson.Gson
import java.net.URL
import com.example.main

fun search_stock(symbol: String): String {
    var apikey = setApiKey()
    var url =
        "https://financialmodelingprep.com/api/v3/quote/$symbol?apikey=$apikey" //symbol value changesPercentage change
    val JsonIN1 = URL(url).readText()
    url = "https://financialmodelingprep.com/api/v3/stock/list?apikey=$apikey" //type
    //val JsonIN3 = URL(url).readText()
    url =
        "https://financialmodelingprep.com/api/v3/profile/$symbol?apikey=$apikey" //currensy company imageUrl
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
        return jsonString
    }

}
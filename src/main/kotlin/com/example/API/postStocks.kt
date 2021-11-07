package com.example.API

import com.example.dataClasses.StockClass.Difference
import com.example.dataClasses.StockClass.Price
import com.example.dataClasses.listStocks.ListStocks
import com.example.dataClasses.listStocks.ListStocksItem
import com.google.gson.Gson
import java.net.URL

fun postStocks(): String {
    var url = "https://financialmodelingprep.com/api/v3/stock/list?apikey=9821c9be1c0c2f131a182998a4c5ff68" //type
    val JsonIN3 = URL(url).readText()
    val gson = Gson()
    val ArrayListStocks = gson.fromJson(JsonIN3, ListStocks::class.java)
    val TestJson = gson.fromJson(JsonIN3, ListStocks::class.java)
    if (TestJson.isEmpty()) {
        return "ERROR"
    } else {
        //==========================================================================================
        val Stock1_Difference = Difference(2.0, 1.0, true, "DAY")
        val Stock1_Price = Price(123.2, "USD", Stock1_Difference)
        //val Stock1 = Stock(symbol, "APPLE", "URL", "stock", Stock1_Price)
        //==========================================================================================
        val ArrayOfSymbols: ArrayList<String> = ArrayList()
        for (value in ArrayListStocks) {
            ArrayOfSymbols.add(value.symbol)
        }

        //==========================================================================================
        if (Stock1_Difference.changesPercentage >= 0) {
            Stock1_Difference.isGrows = true
        } else {
            Stock1_Difference.isGrows = false
        }
        //==========================================================================================
        var jsonString = gson.toJson(ArrayOfSymbols)
        print(ArrayOfSymbols)

        //url =
        //    "https://financialmodelingprep.com/api/v3/quote/$symbol?apikey=9821c9be1c0c2f131a182998a4c5ff68" //symbol value changesPercentage change
        val JsonIN1 = URL(url).readText()
        //url =
        //    "https://financialmodelingprep.com/api/v3/profile/$symbol?apikey=9821c9be1c0c2f131a182998a4c5ff68" //currensy company imageUrl
        val JsonIN2 = URL(url).readText()


        return jsonString
    }
}
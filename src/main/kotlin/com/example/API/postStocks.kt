package com.example.API

//import com.example.dataClasses.StockClass.Difference
//import com.example.dataClasses.StockClass.Price
//import com.example.dataClasses.StockClass.Stock
//import com.example.dataClasses.listStocks.ListStocks
//import com.google.gson.Gson
//import java.net.URL
//
//const val apikey = "e3b78e56511d7dfdbd8000775c51664c"
//fun postStocks(): String {
//    var url = "https://financialmodelingprep.com/api/v3/stock/list?apikey=$apikey" //type
//    val JsonIN3 = URL(url).readText()
//    val gson = Gson()
//    val ArrayListStocks = gson.fromJson(JsonIN3, ListStocks::class.java)
//    val TestJson = gson.fromJson(JsonIN3, ListStocks::class.java)
//    if (TestJson.isEmpty()) {
//        return "ERROR"
//    } else {
//        //==========================================================================================
//        val arrayOfSymbols: ArrayList<String> = ArrayList()
//        for (value in ArrayListStocks) {
//            arrayOfSymbols.add(value.symbol)
//        }
//        //==========================================================================================
//        var stockArray: ArrayList<Stock> = ArrayList()
//        var arrayStocksName100: ArrayList<String> = ArrayList()
//        for (i in 0..10) {
//            arrayStocksName100.add(arrayOfSymbols[i])
//        }
//        //==========================================================================================
//        for (value in arrayStocksName100) {
//            val stock = search_stock(value)
//            val stockJson = gson.fromJson(stock, Stock::class.java)
//            stockArray.add(stockJson)
//        }
//        //==========================================================================================
//        var jsonString = gson.toJson(stockArray)
//        return jsonString
//    }
//}
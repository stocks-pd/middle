package com.example.search.use_cases

import com.example.common.financialmodelingprep.FinancialModelingPrepRepository
import com.example.search.models.Stock

class SearchUseCase {

    suspend fun execute(input: String): List<Stock> {
        return FinancialModelingPrepRepository.search(input)
            .mapNotNull { stock ->
                if (
                    stock.ticker == null
                    || stock.company == null
                    || stock.currency == null
                ) return@mapNotNull null // в случае если какие-то данные не пришли пропускаем эту акцию

                Stock(
                    symbol = stock.ticker,
                    company = stock.company,
                    image = FinancialModelingPrepRepository.image(stock.ticker),
                    type = "stock", // todo update when other types will be available
                    price = FinancialModelingPrepRepository.price(stock.ticker).let { quote ->
                        if (
                            quote?.previousPrice == null
                            || quote.currentPrice == null
                            || quote.changesPercentage == null
                        ) return@mapNotNull null


                        Stock.Price(
                            value = quote.currentPrice ,
                            currency = stock.currency,
                            differences = Stock.Price.Difference(
                                changesPercentage = quote.changesPercentage,
                                change = quote.previousPrice - quote.currentPrice,
                                isGrows = quote.previousPrice <= quote.currentPrice,
                                period = "DAY" // todo update when other periods will be available
                            )
                        )
                    }
                )
            }
    }
}
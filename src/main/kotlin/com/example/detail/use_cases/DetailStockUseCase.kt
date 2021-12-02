package com.example.detail.use_cases

import com.example.common.financialmodelingprep.FinancialModelingPrepRepository
import com.example.detail.models.DetailStock

class DetailStockUseCase {

    suspend fun execute(input: String): List<DetailStock> {
        return FinancialModelingPrepRepository.detail(input)
            .mapNotNull { detailStock ->
                if (
                    detailStock.symbol == null
                    || detailStock.ceo == null
                    || detailStock.country == null
                    || detailStock.companyName == null
                    || detailStock.description == null
                    || detailStock.industry == null
                    || detailStock.sector == null
                    || detailStock.website == null

                ) return@mapNotNull null

                DetailStock(
                    symbol = detailStock.symbol,
                    companyName = detailStock.companyName,
                    country = detailStock.country,
                    description = detailStock.description,
                    industry = detailStock.industry,
                    sector = detailStock.sector,
                    website = detailStock.website,
                    ceo = detailStock.ceo
                )
            }
    }
}
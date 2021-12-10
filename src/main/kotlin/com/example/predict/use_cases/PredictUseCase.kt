package com.example.predict.use_cases

import com.example.common.StonksApi.StockApiRepository
import com.example.predict.models.Predict


class PredictUseCase {


    suspend fun getPredict(ticker: String, periods: String): List<Predict> {
        return StockApiRepository.predict(ticker, periods)
            .mapNotNull { prediction ->
                if (prediction.ds == null
                        || prediction.yhat == null
                        || prediction.yhat_lower == null
                        || prediction.yhat_upper == null
                        || prediction.risk == null
                ) return@mapNotNull null

                Predict(
                    ds = prediction.ds,
                    yhat = prediction.yhat,
                    yhat_lower = prediction.yhat_lower,
                    yhat_upper = prediction.yhat_upper,
                    risk = prediction.risk,
                )
            }
    }

}
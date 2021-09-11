package com.millionquality.cryptstar.currency.domain.mapper

import androidx.annotation.VisibleForTesting
import com.github.mikephil.charting.data.Entry
import com.millionquality.cryptstar.currency.domain.model.MarketInformation
import com.millionquality.cryptstar.currency.domain.model.MarketInformationTimeSpan
import com.millionquality.cryptstar.currency.utils.extension.changeRateOf
import com.millionquality.cryptstar.currency.utils.extension.orZero
import com.millionquality.cryptstar.currency.utils.extension.toCurrency
import com.millionquality.cryptstar.network.model.CoinPriceChartItem
import javax.inject.Inject

class MarketInformationMapper @Inject constructor() {

    fun mapOnMarketPriceChartResponse(
        coinMarketItem: CoinPriceChartItem,
        timeSpan: MarketInformationTimeSpan
    ): MarketInformation {
        val prices = coinMarketItem.prices.map { price ->
            price[1]
        }
        val firstPrice = prices.firstOrNull().orZero()
        val lastPrice = prices.lastOrNull().orZero()

        return MarketInformation(
            currentPrice = lastPrice.toCurrency(),
            openPrice = firstPrice.toCurrency(),
            closePrice = lastPrice.toCurrency(),
            highPrice = prices.maxOrNull().toCurrency(),
            lowPrice = prices.minOrNull().toCurrency(),
            averagePrice = prices.average().toCurrency(),
            changePrice = (lastPrice.minus(firstPrice)).toCurrency(),
            changeRate = "${firstPrice.changeRateOf(lastPrice)}%",
            timespan = timeSpan,
            chartEntries = coinMarketItem.prices.map {
                mapOnMarketPriceValueResponse(it)
            }
        )
    }

    @VisibleForTesting
    fun mapOnMarketPriceValueResponse(coinMarketItem: List<Double>) =
        Entry(
            coinMarketItem[0].toFloat(),
            coinMarketItem[1].toFloat()
        )
}

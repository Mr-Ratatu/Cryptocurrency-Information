package com.millionquality.cryptstar.currency.utils

import android.content.Context
import com.github.mikephil.charting.data.LineDataSet
import com.millionquality.cryptstar.currency.domain.model.MarketInformation
import com.millionquality.cryptstar.currency.domain.model.MarketInformationTimeSpan

class MarketViewState(
    private val marketInformation: MarketInformation
) {

    fun getLineDataSet(context: Context) =
        LineDataSet(marketInformation.chartEntries, "market_price").apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            lineWidth = 2f
            setDrawFilled(true)
            setDrawCircles(false)
        }

    fun isChip1dChecked() = marketInformation.timespan == MarketInformationTimeSpan.TIME_SPAN_1DAYS

    fun isChip7dChecked() = marketInformation.timespan == MarketInformationTimeSpan.TIME_SPAN_7DAYS

    fun isChip30dChecked() = marketInformation.timespan == MarketInformationTimeSpan.TIME_SPAN_30DAYS

    fun isChip60dChecked() = marketInformation.timespan == MarketInformationTimeSpan.TIME_SPAN_60DAYS

    fun isChip90dChecked() = marketInformation.timespan == MarketInformationTimeSpan.TIME_SPAN_90DAYS

    fun isChip1yChecked() = marketInformation.timespan == MarketInformationTimeSpan.TIME_SPAN_1YEAR

}

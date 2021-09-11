package com.millionquality.cryptstar.network.model

import com.google.gson.annotations.SerializedName

data class CoinPriceChartItem(
    @SerializedName("prices")
    val prices: List<List<Double>>,
)

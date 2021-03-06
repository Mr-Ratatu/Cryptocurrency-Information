package com.millionquality.cryptstar.currency.domain.model

import com.github.mikephil.charting.data.Entry

data class MarketInformation(
    val currentPrice: String,
    val openPrice: String,
    val closePrice: String,
    val highPrice: String,
    val lowPrice: String,
    val averagePrice: String,
    val changePrice: String,
    val changeRate: String,
    val timespan: MarketInformationTimeSpan,
    val chartEntries: List<Entry>
)

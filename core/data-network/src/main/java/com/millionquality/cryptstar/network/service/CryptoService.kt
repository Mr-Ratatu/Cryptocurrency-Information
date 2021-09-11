package com.millionquality.cryptstar.network.service

import com.millionquality.cryptstar.network.model.CoinPriceChartItem
import com.millionquality.cryptstar.network.model.CryptoMarketItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoService {

    @GET("coins/markets")
    suspend fun getCoinList(
        @Query("vs_currency") currency: String = "usd"
    ): List<CryptoMarketItem>

    @GET("coins/{id}/market_chart")
    suspend fun getCoinChartInfo(
        @Path("id") coinId: String,
        @Query("days") days: String,
        @Query("vs_currency") currency: String = "usd"
    ): CoinPriceChartItem
}
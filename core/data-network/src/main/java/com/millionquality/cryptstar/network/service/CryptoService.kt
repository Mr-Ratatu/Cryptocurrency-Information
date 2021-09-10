package com.millionquality.cryptstar.network.service

import com.millionquality.cryptstar.data.CryptoMarketItem
import retrofit2.http.GET

interface CryptoService {

    @GET("coins/markets?vs_currency=usd")
    suspend fun getCoinList(): List<CryptoMarketItem>
}
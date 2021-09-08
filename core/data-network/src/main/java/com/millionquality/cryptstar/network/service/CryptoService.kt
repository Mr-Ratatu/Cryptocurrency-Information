package com.millionquality.cryptstar.network.service

import com.millionquality.cryptstar.network.response.CryptoResponse
import retrofit2.http.GET

interface CryptoService {

    @GET("coins/markets?vs_currency=usd")
    suspend fun getCoinList(): CryptoResponse
}
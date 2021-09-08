package com.millionquality.cryptstar.feature_currency.data.source

import com.millionquality.cryptstar.network.response.CryptoResponse
import com.millionquality.cryptstar.network.service.CryptoService
import javax.inject.Inject

class CryptoSource @Inject constructor(
    private val cryptoService: CryptoService
) {

    suspend fun getCoinList(): CryptoResponse = cryptoService.getCoinList()
}
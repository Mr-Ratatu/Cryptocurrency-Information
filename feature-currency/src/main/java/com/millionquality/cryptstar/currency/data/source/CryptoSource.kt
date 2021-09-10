package com.millionquality.cryptstar.currency.data.source

import com.millionquality.cryptstar.data.CryptoMarketItem
import com.millionquality.cryptstar.network.service.CryptoService
import javax.inject.Inject

class CryptoSource @Inject constructor(
    private val cryptoService: CryptoService
) {

    suspend fun getCoinList(): List<CryptoMarketItem> = cryptoService.getCoinList()
}
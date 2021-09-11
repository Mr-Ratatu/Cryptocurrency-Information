package com.millionquality.cryptstar.currency.data.source

import com.millionquality.cryptstar.network.model.CoinPriceChartItem
import com.millionquality.cryptstar.network.model.CryptoMarketItem
import com.millionquality.cryptstar.network.service.CryptoService
import javax.inject.Inject

class CryptoSource @Inject constructor(
    private val cryptoService: CryptoService
) {

    suspend fun getCoinList(): List<CryptoMarketItem> = cryptoService.getCoinList()

    suspend fun getCoinChartInfo(coinId: String, days: String): CoinPriceChartItem =
        cryptoService.getCoinChartInfo(coinId, days)
}
package com.millionquality.cryptstar.currency.domain.repository

import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.network.model.CoinPriceChartItem
import com.millionquality.cryptstar.network.model.CryptoMarketItem
import kotlinx.coroutines.flow.Flow

interface CryptoListRepository {

    fun getCoinList(): Flow<State<List<CryptoMarketItem>>>

    fun getCoinChartInfo(coinId: String, days: String): Flow<State<CoinPriceChartItem>>
}
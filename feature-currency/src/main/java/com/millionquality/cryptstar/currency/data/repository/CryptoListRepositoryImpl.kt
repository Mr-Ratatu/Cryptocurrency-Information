package com.millionquality.cryptstar.currency.data.repository

import com.millionquality.cryptstar.base.data.BaseRepository
import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.network.model.CryptoMarketItem
import com.millionquality.cryptstar.currency.data.source.CryptoSource
import com.millionquality.cryptstar.currency.domain.repository.CryptoListRepository
import com.millionquality.cryptstar.network.model.CoinPriceChartItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoListRepositoryImpl @Inject constructor(
    private val source: CryptoSource
) : CryptoListRepository, BaseRepository() {

    override fun getCoinList(): Flow<State<List<CryptoMarketItem>>> =
        apiCall { source.getCoinList() }

    override fun getCoinChartInfo(coinId: String, days: String): Flow<State<CoinPriceChartItem>> =
        apiCall { source.getCoinChartInfo(coinId, days) }
}
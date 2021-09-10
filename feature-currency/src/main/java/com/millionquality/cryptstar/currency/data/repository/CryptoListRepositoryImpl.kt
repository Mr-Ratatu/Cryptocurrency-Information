package com.millionquality.cryptstar.currency.data.repository

import com.millionquality.cryptstar.base.data.BaseRepository
import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.data.CryptoMarketItem
import com.millionquality.cryptstar.currency.data.source.CryptoSource
import com.millionquality.cryptstar.currency.domain.repository.CryptoListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoListRepositoryImpl @Inject constructor(
    private val source: CryptoSource
): CryptoListRepository, BaseRepository(){

    override fun getCoinList(): Flow<State<List<CryptoMarketItem>>> =
        apiCall { source.getCoinList() }
}
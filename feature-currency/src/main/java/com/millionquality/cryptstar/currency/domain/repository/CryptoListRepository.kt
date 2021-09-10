package com.millionquality.cryptstar.currency.domain.repository

import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.data.CryptoMarketItem
import kotlinx.coroutines.flow.Flow

interface CryptoListRepository {

    fun getCoinList(): Flow<State<List<CryptoMarketItem>>>
}
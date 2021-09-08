package com.millionquality.cryptstar.feature_currency.domain.repository

import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.network.response.CryptoResponse
import kotlinx.coroutines.flow.Flow

interface CryptoListRepository {

    fun getCoinList(): Flow<State<CryptoResponse>>
}
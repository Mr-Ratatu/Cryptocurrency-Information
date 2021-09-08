package com.millionquality.cryptstar.feature_currency.data.repository

import com.millionquality.cryptstar.base.data.BaseRepository
import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.feature_currency.data.source.CryptoSource
import com.millionquality.cryptstar.feature_currency.domain.repository.CryptoListRepository
import com.millionquality.cryptstar.network.response.CryptoResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoListRepositoryImpl @Inject constructor(
    private val source: CryptoSource
): CryptoListRepository, BaseRepository(){

    override fun getCoinList(): Flow<State<CryptoResponse>> =
        apiCall { source.getCoinList() }
}
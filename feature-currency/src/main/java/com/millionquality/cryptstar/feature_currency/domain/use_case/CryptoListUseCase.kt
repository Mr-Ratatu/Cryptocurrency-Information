package com.millionquality.cryptstar.feature_currency.domain

import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.feature_currency.domain.repository.CryptoListRepository
import com.millionquality.cryptstar.network.response.CryptoResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CryptoListUseCase {

    fun getCoinList(): Flow<State<CryptoResponse>>
}

class CryptoListUseCaseImpl @Inject constructor(
    private val repository: CryptoListRepository
) : CryptoListUseCase {

    override fun getCoinList(): Flow<State<CryptoResponse>> = repository.getCoinList()
}
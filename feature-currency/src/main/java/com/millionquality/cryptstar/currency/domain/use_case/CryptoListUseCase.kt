package com.millionquality.cryptstar.currency.domain.use_case

import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.network.model.CryptoMarketItem
import com.millionquality.cryptstar.currency.domain.repository.CryptoListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CryptoListUseCase {

    fun getCoinList(): Flow<State<List<CryptoMarketItem>>>
}

class CryptoListUseCaseImpl @Inject constructor(
    private val repository: CryptoListRepository
) : CryptoListUseCase {

    override fun getCoinList(): Flow<State<List<CryptoMarketItem>>> = repository.getCoinList()
}
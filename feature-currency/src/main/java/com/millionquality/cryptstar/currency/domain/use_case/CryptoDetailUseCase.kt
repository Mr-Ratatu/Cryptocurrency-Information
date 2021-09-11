package com.millionquality.cryptstar.currency.domain.use_case

import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.base.extension.map
import com.millionquality.cryptstar.currency.domain.mapper.MarketInformationMapper
import com.millionquality.cryptstar.currency.domain.model.MarketInformation
import com.millionquality.cryptstar.currency.domain.model.MarketInformationTimeSpan
import com.millionquality.cryptstar.currency.domain.repository.CryptoListRepository
import com.millionquality.cryptstar.network.model.CoinPriceChartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface CryptoDetailUseCase {

    fun getCoinCharInfo(
        coinId: String,
        days: MarketInformationTimeSpan
    ): Flow<State<MarketInformation>>
}

class CryptoDetailUseCaseImpl @Inject constructor(
    private val repository: CryptoListRepository,
    private val marketModelMapper: MarketInformationMapper
) : CryptoDetailUseCase {

    override fun getCoinCharInfo(
        coinId: String,
        days: MarketInformationTimeSpan
    ): Flow<State<MarketInformation>> =
        repository.getCoinChartInfo(coinId, days.value)
            .map { state ->
                state.map { item ->
                    marketModelMapper.mapOnMarketPriceChartResponse(
                        item, days
                    )
                }
            }
}
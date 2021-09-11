package com.millionquality.cryptstar.currency.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.base.extension.doOnError
import com.millionquality.cryptstar.base.extension.doOnLoading
import com.millionquality.cryptstar.base.extension.doOnSuccess
import com.millionquality.cryptstar.currency.domain.model.MarketInformationTimeSpan
import com.millionquality.cryptstar.currency.domain.use_case.CryptoDetailUseCase
import com.millionquality.cryptstar.currency.utils.MarketViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val useCase: CryptoDetailUseCase
) : ViewModel() {

    private val _priceChart = MutableStateFlow<State<MarketViewState>>(State.Loading)
    val priceChart: StateFlow<State<MarketViewState>> = _priceChart.asStateFlow()

    fun getCoinCharInfo(coinId: String, days: MarketInformationTimeSpan) =
        useCase.getCoinCharInfo(coinId, days)
            .doOnLoading {
                _priceChart.value = State.Loading
            }
            .doOnSuccess { item ->
                _priceChart.value = State.Success(MarketViewState(item))
            }
            .doOnError { error ->
                _priceChart.value = State.Error(error)
            }
            .launchIn(viewModelScope)
}
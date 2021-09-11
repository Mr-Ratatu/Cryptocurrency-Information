package com.millionquality.cryptstar.currency.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.base.extension.doOnError
import com.millionquality.cryptstar.base.extension.doOnLoading
import com.millionquality.cryptstar.base.extension.doOnSuccess
import com.millionquality.cryptstar.network.model.CryptoMarketItem
import com.millionquality.cryptstar.currency.domain.use_case.CryptoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val useCase: CryptoListUseCase
) : ViewModel() {

    private val _cryptoList = MutableStateFlow<State<List<CryptoMarketItem>>>(State.Loading)
    val cryptoList: StateFlow<State<List<CryptoMarketItem>>> = _cryptoList.asStateFlow()

    init {
        getCryptoList()
    }

    private fun getCryptoList() = useCase.getCoinList()
        .doOnLoading {
            _cryptoList.value = State.Loading
        }
        .doOnSuccess { response ->
            _cryptoList.value = State.Success(response)
        }
        .doOnError { error ->
            _cryptoList.value = State.Error(error)
        }
        .launchIn(viewModelScope)
}
package com.millionquality.cryptstar.network.response

import com.millionquality.cryptstar.data.CryptoMarketItem

data class CryptoResponse(
    val item: ArrayList<CryptoMarketItem>
)
package com.millionquality.cryptstar.currency.presentation.list.adapter

import com.millionquality.cryptstar.base.ui.adapter.BaseAdapterListener
import com.millionquality.cryptstar.network.model.CryptoMarketItem

interface OnClickCryptoListener: BaseAdapterListener<CryptoMarketItem> {

    fun itemClick(item: CryptoMarketItem)
}
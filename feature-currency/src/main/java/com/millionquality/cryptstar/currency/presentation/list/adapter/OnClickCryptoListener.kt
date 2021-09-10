package com.millionquality.cryptstar.currency.presentation.list.adapter

import com.millionquality.cryptstar.base.ui.adapter.BaseAdapterListener
import com.millionquality.cryptstar.data.CryptoMarketItem

interface OnClickCryptoListener: BaseAdapterListener<CryptoMarketItem> {

    fun itemClick(item: CryptoMarketItem)
}
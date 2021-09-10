package com.millionquality.cryptstar.currency.presentation.list.adapter

import com.millionquality.cryptstar.base.ui.adapter.BaseAdapter
import com.millionquality.cryptstar.base.ui.adapter.DiffUtils
import com.millionquality.cryptstar.data.CryptoMarketItem
import com.millionquality.cryptstar.currency.R

class CryptoListAdapter(
    listener: OnClickCryptoListener
) : BaseAdapter<CryptoMarketItem>(DiffUtils(), listener) {

    override fun getItemViewType(position: Int): Int = R.layout.item_coin
}
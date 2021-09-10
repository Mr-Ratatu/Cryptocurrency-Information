package com.millionquality.cryptstar.base.extension

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.millionquality.cryptstar.base.R

@BindingAdapter("setPriceColor")
fun TextView.setPriceColor(priceChange: Double) {
    this.setTextColor(
        when {
            priceChange > 0 -> context.getCompatColor(R.color.positive)
            else -> context.getCompatColor(R.color.negative)
        }
    )
}

@BindingAdapter("numberText")
fun TextView.setNumberText(text: Number) {
    this.text = text.toString()
}
package com.millionquality.cryptstar.base.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.millionquality.cryptstar.base.R

@BindingAdapter("loadImg")
fun ImageView.setLoadImg(url: String) {
    this.load(url)
}

@BindingAdapter("setArrowImg")
fun ImageView.setArrowImg(priceChange: Double) {
    this.setImageResource(
        when {
            priceChange > 0 -> R.drawable.ic_arrow_positive
            else -> R.drawable.ic_arrow_negative
        }
    )
}
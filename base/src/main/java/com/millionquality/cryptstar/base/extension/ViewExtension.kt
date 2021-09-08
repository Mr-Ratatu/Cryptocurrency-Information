package com.millionquality.cryptstar.base.extension

import android.view.View
import androidx.databinding.BindingAdapter

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

@BindingAdapter("visibleList")
fun View.setVisibleList(size: Int) {
    this.visibility = if (size > 0) View.GONE else View.VISIBLE
}
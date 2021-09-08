package com.millionquality.cryptstar.base.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("img")
fun ImageView.setImg(url: String) {
    this.load(url)
}
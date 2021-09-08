package com.millionquality.cryptstar.base.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("adapter")
fun RecyclerView.setAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

inline fun <reified T : ViewDataBinding> ViewGroup.inflateWithBinding(
    layoutId: Int,
    attachToRoot: Boolean = false
): T {
    val inflater = LayoutInflater.from(context)

    return inflater.inflateBinding(layoutId, this, attachToRoot)
}

inline fun <reified T : ViewDataBinding> LayoutInflater.inflateBinding(
    layoutId: Int,
    viewGroup: ViewGroup?,
    attachToRoot: Boolean = false
): T = DataBindingUtil.inflate(this, layoutId, viewGroup, attachToRoot)
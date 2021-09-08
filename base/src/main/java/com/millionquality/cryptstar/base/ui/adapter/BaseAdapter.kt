package com.millionquality.cryptstar.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.millionquality.cryptstar.base.BR

abstract class BaseAdapter<T>(
    diffUtils: DiffUtil.ItemCallback<T>,
    private val listener: BaseAdapterListener<T>? = null
) : ListAdapter<T, BaseAdapter.ViewHolder<T>>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, viewType, parent, false
        )

        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder<T>(
        private val binding: ViewDataBinding,
        private val listener: BaseAdapterListener<T>?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.setVariable(BR.items, item)
            listener?.let {
                binding.setVariable(BR.listener, it)
            } ?: binding.setVariable(BR.listener, object : BaseAdapterListener<T> {})
            binding.executePendingBindings()
        }
    }
}
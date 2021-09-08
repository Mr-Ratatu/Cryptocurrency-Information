package com.millionquality.cryptstar.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.millionquality.cryptstar.base.extension.autoCleared

abstract class BaseFragment<VB : ViewDataBinding>(
    @LayoutRes val layoutId: Int
) : Fragment() {

    protected var binding by autoCleared<VB>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<VB>(
            inflater,
            layoutId,
            container,
            false
        ).also { binding ->
            this.binding = binding
        }.root
    }
}
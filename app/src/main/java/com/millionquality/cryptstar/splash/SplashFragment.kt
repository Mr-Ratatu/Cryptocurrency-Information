package com.millionquality.cryptstar.splash

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.millionquality.cryptstar.R
import com.millionquality.cryptstar.base.ui.BaseFragment
import com.millionquality.cryptstar.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(1500)
            findNavController().navigate(R.id.action_splashFragment_to_navigation_main)
        }
    }
}

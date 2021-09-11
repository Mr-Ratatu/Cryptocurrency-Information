package com.millionquality.cryptstar.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.millionquality.cryptstar.base.ui.BaseFragment
import com.millionquality.cryptstar.home.databinding.FragmentMainBinding

class MainFragment: BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = (childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment)
            .navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}
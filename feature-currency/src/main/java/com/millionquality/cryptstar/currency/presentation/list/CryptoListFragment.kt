package com.millionquality.cryptstar.currency.presentation.list

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.base.extension.autoCleared
import com.millionquality.cryptstar.base.extension.getCompatColor
import com.millionquality.cryptstar.base.extension.launchWhenStarted
import com.millionquality.cryptstar.base.ui.BaseFragment
import com.millionquality.cryptstar.network.model.CryptoMarketItem
import com.millionquality.cryptstar.currency.R
import com.millionquality.cryptstar.currency.databinding.FragmentCryptoListBinding
import com.millionquality.cryptstar.currency.presentation.list.adapter.OnClickCryptoListener
import com.millionquality.cryptstar.currency.presentation.list.adapter.CryptoListAdapter
import com.millionquality.cryptstar.currency.utils.extension.shimmerHide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoListFragment : BaseFragment<FragmentCryptoListBinding>(R.layout.fragment_crypto_list),
    OnClickCryptoListener {

    private val cryptoListViewModel: CryptoListViewModel by viewModels()
    private var cryptoListAdapter: CryptoListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()

        setupView()
        observeData()
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding.layoutToolbar.currencyToolbar)
            supportActionBar?.apply {
                setDisplayShowTitleEnabled(false)
                setBackgroundDrawable(
                    ColorDrawable(requireContext().getCompatColor(R.color.background_color))
                )
            }
        }
        setHasOptionsMenu(true)
    }

    private fun setupView() {
        cryptoListAdapter = CryptoListAdapter(this)

        with(binding) {
            adapter = cryptoListAdapter

            cryptoList.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }

    private fun observeData() {
        with(cryptoListViewModel) {
            cryptoList.launchWhenStarted(lifecycleScope) { state ->
                setStateForUi(state)
            }
        }
    }

    private fun setStateForUi(state: State<List<CryptoMarketItem>>) {
        when (state) {
            is State.Loading -> {
                binding.layoutShimmer.shimmerLayout.startShimmer()
            }
            is State.Success -> {
                binding.layoutShimmer.shimmerLayout.shimmerHide()
                cryptoListAdapter.submitList(state.data)
            }
            is State.Error -> {
                Log.d("TAG", "setStateForUi: error")
            }
        }
    }

    override fun itemClick(item: CryptoMarketItem) {
        findNavController().navigate(
            CryptoListFragmentDirections.actionCryptoListToCryptoDetail(
                item
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.currency_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.currencySearch ->
                Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT)
                    .show()

            R.id.currencyFiltered ->
                findNavController().navigate(CryptoListFragmentDirections.actionCryptoListToFilterDialog())
        }

        return true
    }
}
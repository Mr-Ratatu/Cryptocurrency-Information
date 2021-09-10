package com.millionquality.cryptstar.currency.presentation.list

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
import com.millionquality.cryptstar.data.CryptoMarketItem
import com.millionquality.cryptstar.currency.R
import com.millionquality.cryptstar.currency.databinding.FragmentCryptoListBinding
import com.millionquality.cryptstar.currency.presentation.list.adapter.OnClickCryptoListener
import com.millionquality.cryptstar.currency.presentation.list.adapter.CryptoListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoListFragment : BaseFragment<FragmentCryptoListBinding>(R.layout.fragment_crypto_list),
    OnClickCryptoListener {

    private val cryptoListViewModel: CryptoListViewModel by viewModels()
    private var cryptoListAdapter: CryptoListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.currencyToolbar)
        setHasOptionsMenu(true)

        setupView()
        observeData()
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

            currencyToolbar.apply {
                title = ""
                setBackgroundColor(requireContext().getCompatColor(R.color.background_color))
            }
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
            is State.Loading -> Log.d("TAG", "setStateForUi: loading")
            is State.Success -> cryptoListAdapter.submitList(state.data)
            is State.Error -> Log.d("TAG", "setStateForUi: error")
        }
    }

    override fun itemClick(item: CryptoMarketItem) {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.currency_menu, menu)
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
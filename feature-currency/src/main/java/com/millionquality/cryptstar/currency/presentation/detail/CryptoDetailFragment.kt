package com.millionquality.cryptstar.currency.presentation.detail

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.millionquality.cryptstar.base.data.State
import com.millionquality.cryptstar.base.extension.getCompatColor
import com.millionquality.cryptstar.base.extension.gone
import com.millionquality.cryptstar.base.extension.launchWhenStarted
import com.millionquality.cryptstar.base.extension.visible
import com.millionquality.cryptstar.base.ui.BaseFragment
import com.millionquality.cryptstar.currency.R
import com.millionquality.cryptstar.currency.databinding.FragmentCryptoDetailBinding
import com.millionquality.cryptstar.currency.domain.model.MarketInformationTimeSpan
import com.millionquality.cryptstar.currency.utils.MarketViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoDetailFragment : BaseFragment<FragmentCryptoDetailBinding>(
    R.layout.fragment_crypto_detail
) {

    private val args: CryptoDetailFragmentArgs by navArgs()
    private val detailViewModel: CryptoDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()

        setupView()
        observeData()
    }

    private fun setupView() {
        with(binding) {
            items = args.coinItem
            detailLineChart.apply {
                description.isEnabled = false
                isDragEnabled = true
                xAxis.isEnabled = false
                axisLeft.setDrawAxisLine(true)
                axisRight.isEnabled = false
                legend.isEnabled = false
                setTouchEnabled(true)
                setScaleEnabled(true)
                setDrawGridBackground(false)
                setDrawBorders(false)
                invalidate()
            }

            detailTimeSpanOneDay.setOnClickListener {
                getCoinPriceTimeSpan(MarketInformationTimeSpan.TIME_SPAN_1DAYS)
            }

            detailTimeSpanSevenDays.setOnClickListener {
                getCoinPriceTimeSpan(MarketInformationTimeSpan.TIME_SPAN_7DAYS)
            }

            detailTimeSpanThirtyDays.setOnClickListener {
                getCoinPriceTimeSpan(MarketInformationTimeSpan.TIME_SPAN_30DAYS)
            }

            detailTimeSpanSixtyDays.setOnClickListener {
                getCoinPriceTimeSpan(MarketInformationTimeSpan.TIME_SPAN_60DAYS)
            }

            detailTimeSpanNinetyDays.setOnClickListener {
                getCoinPriceTimeSpan(MarketInformationTimeSpan.TIME_SPAN_90DAYS)
            }

            detailTimeSpanOneYear.setOnClickListener {
                getCoinPriceTimeSpan(MarketInformationTimeSpan.TIME_SPAN_1YEAR)
            }
        }
    }

    private fun observeData() {
        getCoinPriceTimeSpan()
        with(detailViewModel) {
            priceChart.launchWhenStarted(lifecycleScope) { state ->
                setStateForUi(state)
            }
        }
    }

    private fun getCoinPriceTimeSpan(
        timeSpan: MarketInformationTimeSpan = MarketInformationTimeSpan.TIME_SPAN_30DAYS
    ) {
        detailViewModel.getCoinCharInfo(args.coinItem.id, timeSpan)
    }

    private fun setStateForUi(state: State<MarketViewState>) {
        with(binding) {
            when (state) {
                is State.Loading -> {
                    detailChartLoading.visible()
                }
                is State.Success -> {
                    detailChartLoading.gone()
                    detailLineChart.visible()
                    marketViewState = state.data
                }
                is State.Error -> {
                    detailChartLoading.gone()
                }
            }
        }
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding.detailToolbar)
            supportActionBar?.apply {
                setDisplayShowTitleEnabled(false)
                setBackgroundDrawable(
                    ColorDrawable(requireContext().getCompatColor(R.color.background_color))
                )
                setDisplayHomeAsUpEnabled(true)
            }
        }
        binding.detailToolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.currency_detail_menu, menu)
    }
}
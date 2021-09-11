package com.millionquality.cryptstar.currency.utils.extension

import android.view.View
import com.facebook.shimmer.ShimmerFrameLayout

fun ShimmerFrameLayout.shimmerHide() {
    this.apply {
        stopShimmer()
        visibility = View.GONE
    }
}
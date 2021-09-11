package com.millionquality.cryptstar.currency.domain.model

enum class MarketInformationTimeSpan(val value: String) {
    TIME_SPAN_1DAYS("1"),
    TIME_SPAN_7DAYS("7"),
    TIME_SPAN_30DAYS("30"),
    TIME_SPAN_60DAYS("60"),
    TIME_SPAN_90DAYS("90"),
    TIME_SPAN_1YEAR("365");
}

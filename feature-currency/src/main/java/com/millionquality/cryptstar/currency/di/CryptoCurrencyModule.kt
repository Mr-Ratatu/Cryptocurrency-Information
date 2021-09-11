package com.millionquality.cryptstar.currency.di

import com.millionquality.cryptstar.currency.data.repository.CryptoListRepositoryImpl
import com.millionquality.cryptstar.currency.data.source.CryptoSource
import com.millionquality.cryptstar.currency.domain.mapper.MarketInformationMapper
import com.millionquality.cryptstar.currency.domain.use_case.CryptoListUseCase
import com.millionquality.cryptstar.currency.domain.use_case.CryptoListUseCaseImpl
import com.millionquality.cryptstar.currency.domain.repository.CryptoListRepository
import com.millionquality.cryptstar.currency.domain.use_case.CryptoDetailUseCase
import com.millionquality.cryptstar.currency.domain.use_case.CryptoDetailUseCaseImpl
import com.millionquality.cryptstar.network.service.CryptoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CryptoCurrencyModule {

    @Provides
    @Singleton
    fun provideCryptoSource(api: CryptoService): CryptoSource = CryptoSource(api)

    @Provides
    @Singleton
    fun provideCryptoRepo(source: CryptoSource): CryptoListRepository =
        CryptoListRepositoryImpl(source)

    @Provides
    @Singleton
    fun provideCryptoListUseCase(repository: CryptoListRepository): CryptoListUseCase =
        CryptoListUseCaseImpl(repository)

    @Provides
    @Singleton
    fun provideCryptoDetailUseCase(
        repository: CryptoListRepository,
        marketInformationMapper: MarketInformationMapper
    ): CryptoDetailUseCase =
        CryptoDetailUseCaseImpl(repository, marketInformationMapper)
}
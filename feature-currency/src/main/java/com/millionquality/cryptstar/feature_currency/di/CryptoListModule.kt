package com.millionquality.cryptstar.feature_currency.di

import com.millionquality.cryptstar.feature_currency.data.repository.CryptoListRepositoryImpl
import com.millionquality.cryptstar.feature_currency.data.source.CryptoSource
import com.millionquality.cryptstar.feature_currency.domain.CryptoListUseCase
import com.millionquality.cryptstar.feature_currency.domain.CryptoListUseCaseImpl
import com.millionquality.cryptstar.feature_currency.domain.repository.CryptoListRepository
import com.millionquality.cryptstar.network.service.CryptoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CryptoListModule {

    @Provides
    @Singleton
    fun provideCryptoSource(api: CryptoService): CryptoSource = CryptoSource(api)

    @Provides
    @Singleton
    fun provideCryptoRepo(source: CryptoSource): CryptoListRepository =
        CryptoListRepositoryImpl(source)

    @Provides
    @Singleton
    fun provideCryptoUseCase(repository: CryptoListRepository): CryptoListUseCase =
        CryptoListUseCaseImpl(repository)
}
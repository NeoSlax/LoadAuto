package ru.neoslax.loadauto.di

import dagger.Module
import dagger.Provides
import ru.neoslax.loadauto.data.remote.ApiFactory
import ru.neoslax.loadauto.data.remote.ApiService

@Module
object ApiModule {

    @Provides
    fun provideApiService(): ApiService {
        return ApiFactory.apiService
    }
}
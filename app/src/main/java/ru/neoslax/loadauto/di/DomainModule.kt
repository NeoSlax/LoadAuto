package ru.neoslax.loadauto.di

import dagger.Binds
import dagger.Module
import ru.neoslax.loadauto.data.repository.CarRepositoryImpl
import ru.neoslax.loadauto.data.repository.MockRepositoryImpl
import ru.neoslax.loadauto.domain.repository.CarRepository

@Module
interface DomainModule {

    @Binds
    @MockData
    fun bindMockRepository(impl: MockRepositoryImpl): CarRepository

    @Binds
    @ProdData
    fun bindRealRepository(impl: CarRepositoryImpl): CarRepository
}
package ru.neoslax.loadauto.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MockData

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ProdData
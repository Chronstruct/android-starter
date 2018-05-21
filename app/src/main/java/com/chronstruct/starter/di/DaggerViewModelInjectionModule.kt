package com.chronstruct.starter.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

// TODO: Remove and replace with https://github.com/alexfacciorusso/DaggerViewModel when it updates to androidx

/**
 * Configures bindings to [DaggerViewModelFactory], injectable into a [ViewModelProvider.Factory].
 */
@Module
abstract class DaggerViewModelInjectionModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}
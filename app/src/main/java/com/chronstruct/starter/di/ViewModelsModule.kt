package com.chronstruct.starter.di

import androidx.lifecycle.ViewModel
import com.chronstruct.starter.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Defined bindings for all ViewModels
 *
 * For how this works, see https://medium.com/@alexfacciorusso/understanding-dagger-2-multibindings-viewmodel-8418eb372848
 */
@Module
abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    // Add keys to other ViewModels for factory use
}
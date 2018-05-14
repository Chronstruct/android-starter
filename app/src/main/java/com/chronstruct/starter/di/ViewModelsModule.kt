package com.chronstruct.starter.di

import com.alexfacciorusso.daggerviewmodel.ViewModelKey
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
//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel::class)
//    abstract fun bindTallyViewModel(mainViewModel: MainViewModel): ViewModel

    // Add keys to other ViewModels for factory use
}
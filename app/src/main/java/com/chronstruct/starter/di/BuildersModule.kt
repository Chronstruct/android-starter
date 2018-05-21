package com.chronstruct.starter.di

import com.chronstruct.starter.ui.main.MainActivity
import com.chronstruct.starter.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Defined bindings for all subcomponents (activities and fragments).
 * Note that @ContributesAndroidInjector annotation (introduced in 2.11) frees us from having to
 * create separate components annotated with @Subcomponent.
 *
 * https://proandroiddev.com/exploring-the-new-dagger-android-module-9eb6075f1a46
 */
@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

//    @ContributesAndroidInjector
//    abstract fun bindDetailActivity(): DetailActivity

//    @ContributesAndroidInjector
//    abstract fun bindAddTallyFragment(): AddTallyDialogFragment

    // Add bindings for other sub-components here
}
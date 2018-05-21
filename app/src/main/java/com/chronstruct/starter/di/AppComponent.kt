package com.chronstruct.starter.di

import com.chronstruct.starter.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Root of Dagger graph.
 * Responsible for providing app-scoped instances (SharedPrefs, OkHttp, DB).
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    DaggerViewModelInjectionModule::class,
    AppModule::class,
    BuildersModule::class,
    ViewModelsModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

    // all classes that need Field Injection
//    fun inject(activityMain: ActivityMain)
//    fun inject(app: App)
}
package com.chronstruct.starter

import android.util.Log
import com.chronstruct.starter.di.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    /**
     * A tree which logs important information for crash reporting.
     * from https://github.com/JakeWharton/timber/blob/master/timber-sample/src/main/java/com/example/timber/ExampleApp.java
     */
    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }

//            FakeCrashLibrary.log(priority, tag, message)

            if (t != null) {
                if (priority == Log.ERROR) {
//                    FakeCrashLibrary.logError(t)
                } else if (priority == Log.WARN) {
//                    FakeCrashLibrary.logWarning(t)
                }
            }
        }
    }
}
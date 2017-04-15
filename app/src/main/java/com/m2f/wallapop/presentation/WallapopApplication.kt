package com.m2f.wallapop.presentation

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.m2f.wallapop.BuildConfig

/**
 * @author Marc Moreno
 * @version 1
 */
class WallapopApplication: Application() {

    companion object {
        lateinit var appContext: Context
            private set
    }

//    val applicationComponent: ApplicationComponent by lazy {
//        DaggerApplicationComponent.builder()
//                .applicationModule(ApplicationModule(this))
//                .build()
//    }

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext

        if(BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().apply {
                detectAll()
                penaltyLog()
            }.build())

            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().apply {
                detectAll()
                penaltyLog()
            }.build())
        }

    }
}
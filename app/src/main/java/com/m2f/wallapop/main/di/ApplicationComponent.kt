package com.m2f.wallapop.main.di

import android.content.Context
import com.m2f.wallapop.main.di.ApplicationModule
import com.m2f.wallapop.main.di.NetworkModule
import com.m2f.wallapop.domain.executor.PostExecutionThread
import dagger.Component
import retrofit2.Retrofit
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * @author Marc Moreno
 * @version 1
 */
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
@Singleton
interface ApplicationComponent {

    // exposed to sub-components
    fun context(): Context
    fun postExecutionThread(): PostExecutionThread
    fun threadExecutor(): Executor
    fun retrofit(): Retrofit
}
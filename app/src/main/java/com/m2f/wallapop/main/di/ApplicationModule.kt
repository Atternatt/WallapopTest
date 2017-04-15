package com.m2f.wallapop.main.di

import android.app.Application
import android.content.Context
import com.m2f.wallapop.data.executor.JobExecutor
import com.m2f.wallapop.domain.executor.PostExecutionThread
import com.m2f.wallapop.presentation.UIThread
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * @author Marc Moreno
 * @version 1
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun providesThreadExecutor(jobExecutor: JobExecutor): Executor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providesPostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }
}
package com.example.apple.mindsharpner.di.modules

import android.app.Application
import android.content.Context
import com.example.apple.mindsharpner.base.SchedulerProvider
import com.example.apple.mindsharpner.base.schedulers.AppSchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideSchedulers(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    internal fun provideAppContext(application: Application): Context {
        return application
    }
}
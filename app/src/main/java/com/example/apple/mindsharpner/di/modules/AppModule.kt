package com.example.apple.mindsharpner.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.apple.mindsharpner.base.SchedulerProvider
import com.example.apple.mindsharpner.base.schedulers.AppSchedulerProvider
import com.example.apple.mindsharpner.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    private val DB_NAME = "mindsharpner_room"

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

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}
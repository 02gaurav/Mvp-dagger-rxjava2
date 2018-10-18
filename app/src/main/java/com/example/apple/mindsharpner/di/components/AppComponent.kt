package com.example.apple.mindsharpner.di.components

import android.app.Application
import com.example.apple.mindsharpner.MyApplication
import com.example.apple.mindsharpner.di.builders.ActivityBindingModule
import com.example.apple.mindsharpner.di.modules.AppModule
import com.example.apple.mindsharpner.di.modules.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        AppModule::class,
        NetModule::class,
        ActivityBindingModule::class))
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
}

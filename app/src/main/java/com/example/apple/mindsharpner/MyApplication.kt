package com.example.apple.mindsharpner

import com.example.apple.mindsharpner.di.components.AppComponent
import com.example.apple.mindsharpner.di.components.DaggerAppComponent
import com.example.apple.mindsharpner.utils.NetworkUtils


import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class MyApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent
    @Inject
    protected lateinit var networkUtils : NetworkUtils

    override fun onCreate() {
        super.onCreate()
        networkUtils.registerAll()
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
         appComponent = DaggerAppComponent.builder().application(this).build()
         return  appComponent
    }

}

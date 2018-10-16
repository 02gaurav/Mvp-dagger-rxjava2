package com.example.apple.mindsharpner

import com.example.apple.mindsharpner.di.components.AppComponent
import com.example.apple.mindsharpner.di.components.DaggerAppComponent


import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    lateinit var appComponent: AppComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
         appComponent = DaggerAppComponent.builder().application(this).build()
         return  appComponent
    }

}

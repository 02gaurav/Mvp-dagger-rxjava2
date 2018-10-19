package com.example.apple.mindsharpner.splash

import com.example.apple.mindsharpner.di.scopes.ActivityScoped
import dagger.Binds
import dagger.Module

@Module

abstract class SplashModule {
    @Binds
    @ActivityScoped
    abstract fun bindSplashPresenter(presenter: SplashPresenter) : SplashContract.Presenter
}
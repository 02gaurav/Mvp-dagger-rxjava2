package com.example.apple.mindsharpner.mind

import com.example.apple.mindsharpner.di.scopes.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class MindModule {

    @Binds
    @ActivityScoped
    abstract fun bindMathPresenter (presenter: MathPresenter) : MathContract.Presenter
}
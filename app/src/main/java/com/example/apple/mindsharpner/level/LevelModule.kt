package com.example.apple.mindsharpner.level

import com.example.apple.mindsharpner.di.scopes.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class LevelModule {
    @Binds
    @ActivityScoped
    abstract fun bindLevelPresenter(presenter: LevelPresenter) : LevelContract.Presenter
}
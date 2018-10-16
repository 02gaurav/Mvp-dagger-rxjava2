package com.example.apple.mindsharpner.di.builders

import com.example.apple.mindsharpner.di.scopes.ActivityScoped
import com.example.apple.mindsharpner.mind.MathActivity
import com.example.apple.mindsharpner.mind.MindModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module

abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MindModule::class))
    internal abstract fun bindMathActivity() : MathActivity
}
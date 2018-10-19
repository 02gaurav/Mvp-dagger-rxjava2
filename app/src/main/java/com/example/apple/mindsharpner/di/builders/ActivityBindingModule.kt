package com.example.apple.mindsharpner.di.builders

import com.example.apple.mindsharpner.di.scopes.ActivityScoped
import com.example.apple.mindsharpner.level.LevelActivity
import com.example.apple.mindsharpner.level.LevelModule
import com.example.apple.mindsharpner.mind.MathActivity
import com.example.apple.mindsharpner.mind.MindModule
import com.example.apple.mindsharpner.ques.QuestionActivity
import com.example.apple.mindsharpner.ques.QuestionModule
import com.example.apple.mindsharpner.splash.SplashActivity
import com.example.apple.mindsharpner.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module

abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MindModule::class))
    internal abstract fun bindMathActivity() : MathActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(LevelModule::class))
    internal abstract fun bindLevelActivity() : LevelActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(QuestionModule::class))
    internal abstract fun bindQuestionActivity() : QuestionActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    internal abstract fun bindSplashActivity() : SplashActivity

}
package com.example.apple.mindsharpner.ques

import com.example.apple.mindsharpner.di.scopes.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class QuestionModule{
    @Binds
    @ActivityScoped
    abstract fun bindQuestionPresenter(presenter: QuestionPresenter) : QuestionContract.Presenter
}
package com.example.apple.mindsharpner.ques

import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.base.MvpView
import com.example.apple.mindsharpner.data.QuestionEntity

abstract class QuestionContract{
    interface View : MvpView {
        fun setView()
        fun showMessage()
        fun showError()
        fun setData(it: List<QuestionEntity>)
        fun setUpRecyclerView()
    }

    interface Presenter : MvpPresenter<View> {

        fun fetchQuestions()
        fun initializeAdapter()
        fun verifyAnswer()
        fun isInternetAvailable()
    }
}
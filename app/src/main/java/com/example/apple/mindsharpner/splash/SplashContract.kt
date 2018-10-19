package com.example.apple.mindsharpner.splash

import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.base.MvpView

abstract class SplashContract{

    interface View : MvpView{
        fun startLevelActivity()
    }

    interface Presenter : MvpPresenter<View> {

        fun waitForlaunch()
    }
}
package com.example.apple.mindsharpner.splash

import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.base.MvpView

abstract class SplashContract{

    interface View : MvpView

    interface Presenter : MvpPresenter<View>
}
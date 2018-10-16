package com.example.apple.mindsharpner.base

import dagger.android.support.DaggerAppCompatActivity

abstract class BaseMvpActivity<V : MvpView> :  DaggerAppCompatActivity() {

    abstract fun getPresenter(): MvpPresenter<V>

}
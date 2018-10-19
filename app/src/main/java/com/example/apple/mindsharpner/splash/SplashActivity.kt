package com.example.apple.mindsharpner.splash

import com.example.apple.mindsharpner.base.BaseMvpActivity
import com.example.apple.mindsharpner.base.MvpPresenter
import javax.inject.Inject

class SplashActivity : BaseMvpActivity<SplashContract.View>(), SplashContract.View{

    @Inject
    protected lateinit var mPresenter: SplashPresenter
    override fun getPresenter(): MvpPresenter<SplashContract.View> = mPresenter

}
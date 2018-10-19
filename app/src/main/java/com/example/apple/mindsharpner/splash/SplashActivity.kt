package com.example.apple.mindsharpner.splash

import android.content.Intent
import android.os.Bundle
import com.example.apple.mindsharpner.R
import com.example.apple.mindsharpner.base.BaseMvpActivity
import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.level.LevelActivity
import javax.inject.Inject

class SplashActivity : BaseMvpActivity<SplashContract.View>(), SplashContract.View{

    @Inject
    protected lateinit var mPresenter: SplashPresenter
    override fun getPresenter(): MvpPresenter<SplashContract.View> = mPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.takeView(this)
        setContentView(R.layout.activity_splash)
        mPresenter.waitForlaunch()
    }

    override fun startLevelActivity() {
        val intent = Intent(this, LevelActivity::class.java)
        startActivity(intent)
    }

}
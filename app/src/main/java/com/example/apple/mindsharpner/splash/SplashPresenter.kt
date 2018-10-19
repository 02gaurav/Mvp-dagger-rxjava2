package com.example.apple.mindsharpner.splash

import android.os.Handler
import com.example.apple.mindsharpner.base.BasePresenter
import javax.inject.Inject
import kotlin.concurrent.timerTask
import kotlin.system.measureNanoTime
import android.support.v4.os.HandlerCompat.postDelayed



class SplashPresenter
@Inject
constructor() :  BasePresenter<SplashContract.View>(), SplashContract.Presenter{

    companion object {
        const val SPLASH_SCREEN_TIMEOUT = 3L
    }

    override fun waitForlaunch() {
        val handler = Handler()
        handler.postDelayed({
            mView?.startLevelActivity()
        }, 4000)
    }
}
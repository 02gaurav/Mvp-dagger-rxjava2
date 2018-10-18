package com.example.apple.mindsharpner.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.bumptech.glide.manager.ConnectivityMonitor
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkUtils
@Inject
constructor(private val application: Application) {

    companion object {

        private val mApplicationForegroundSubject = BehaviorSubject.create<Boolean>()
        private val mNetworkConnectedSubject = PublishSubject.create<Boolean>()
        fun addCurrentNetworkState(isConnected : Boolean) {
            mNetworkConnectedSubject.onNext(isConnected)
        }
    }

    private lateinit var mConnectivityMonitor: ConnectivityMonitor
    private val mConnectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


    fun registerAll() {
        registerNetworkChangeReceiver(application)
    }

    private fun registerNetworkChangeReceiver(application: Application) {
        mConnectivityMonitor = DefaultConnectivityMonitorFactory().build(application) {
            addCurrentNetworkState(it)
        }
    }

    val isConnected: Boolean
        @Synchronized get() {
            val info = mConnectivityManager.activeNetworkInfo
            return info != null && info.isConnected
        }
}
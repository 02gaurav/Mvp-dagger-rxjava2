package com.example.apple.mindsharpner.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : MvpView> : MvpPresenter<T> {
    override var mView: T? = null

    override var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun takeView(view: T) {
        super.takeView(view)
        onViewInitialized()
    }

    open fun onViewInitialized() {}

    override fun dropView() {
        super.dropView()
    }
}
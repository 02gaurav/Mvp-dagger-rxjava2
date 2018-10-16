package com.example.apple.mindsharpner.base

import io.reactivex.disposables.CompositeDisposable

interface MvpPresenter<T : MvpView> {

    var mView: T?

    var mCompositeDisposable: CompositeDisposable


    fun takeView(view: T) {
        mView = view
    }

    fun dropView() {
        mView = null
        mCompositeDisposable.clear()
    }
}
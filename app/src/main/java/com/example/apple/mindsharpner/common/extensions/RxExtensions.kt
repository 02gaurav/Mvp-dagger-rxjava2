package com.example.apple.mindsharpner.common.extensions

import com.example.apple.mindsharpner.base.SchedulerProvider
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer

fun <T> applyIoUiSchedulers(mSchedulerProvider: SchedulerProvider) : ObservableTransformer<T, T> {

    return ObservableTransformer { upstream ->
        upstream.subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
    }
}

fun <T> applyIOUISchedulerSingle(mSchedulerProvider: SchedulerProvider): SingleTransformer<T, T> {
    return SingleTransformer { upstream ->
        upstream.subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
    }

}
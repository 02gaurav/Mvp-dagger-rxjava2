package com.example.apple.mindsharpner.level

import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.base.MvpView
import com.example.apple.mindsharpner.level.data.Levels

abstract class LevelContract {
    interface View : MvpView {
        fun getList(mlevelList: List<Levels>)
    }

    interface Presenter : MvpPresenter<View> {
        fun getAllLevel()
    }
}
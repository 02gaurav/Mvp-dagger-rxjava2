package com.example.apple.mindsharpner.mind

import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.base.MvpView
import com.example.apple.mindsharpner.data.TwoNumbers

abstract class MathContract {
    interface View : MvpView {
        fun setView(twoNumbers: TwoNumbers)
        fun showMessage()
        fun setOperator(op :String)
        fun setCount(correct : String, inCorrect :String)

    }


    interface Presenter : MvpPresenter<View> {

        fun genrateNumbers(level : Int)
        fun genrateOperators(level : Int)
        fun verifyAnswer(f : Int, s :Int, res :Int, op :String)

    }
}
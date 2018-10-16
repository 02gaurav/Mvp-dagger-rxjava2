package com.example.apple.mindsharpner.mind

import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.base.MvpView
import com.example.apple.mindsharpner.data.TwoNumbers

abstract class MathContract {
    interface View : MvpView {
        fun setView(twoNumbers: TwoNumbers)
        fun showMessage()
        fun setOperator(op :String)
        fun setCount(correct : String, incorrect :String)

    }


    interface Presenter : MvpPresenter<View> {

        fun genrateNumbers()
        fun genrateOperators()
        fun verifyAnswer(f : Int, s :Int, res :Int, op :String)

    }
}
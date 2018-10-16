package com.example.apple.mindsharpner.mind

import com.example.apple.mindsharpner.base.BasePresenter

import com.example.apple.mindsharpner.repo.NumberRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MathPresenter
    @Inject
    constructor(private val mNumberRepository: NumberRepository): BasePresenter<MathContract.View>(), MathContract.Presenter {

    companion object {

        private var correct : Int = 0
        private var inCorrect : Int = 0
    }

    override fun genrateNumbers() {
        mCompositeDisposable.add(mNumberRepository.genrateTwoNumber()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView?.setView(it)
                },{
                    it.printStackTrace()
                    mView?.showMessage()
                }))
    }

    override fun genrateOperators() {
        mCompositeDisposable.add(mNumberRepository.genrateOperator()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                   mView?.setOperator(it)
                },{
                    it.printStackTrace()
                    mView?.showMessage()
                }))
    }

    override fun verifyAnswer(f : Int, s :Int, res :Int, op :String) {
        when(op){
            "+" ->{

                if (f+s == res) {
                    correct++
                } else {
                   inCorrect++
                }

            }

            "-" ->{

                if (f-s == res) {
                    correct++
                } else {
                    inCorrect++
                }

            }

            "/" ->{

                if (f/s == res) {
                    correct++
                } else {
                    inCorrect++
                }

            }

            "*" ->{

                if (f*s == res) {
                    correct++
                } else {
                    inCorrect++
                }
            }
        }

        mView?.setCount(correct.toString(), inCorrect.toString())
    }

}
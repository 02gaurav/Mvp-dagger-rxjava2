package com.example.apple.mindsharpner.ques

import com.example.apple.mindsharpner.base.BasePresenter
import com.example.apple.mindsharpner.base.SchedulerProvider
import com.example.apple.mindsharpner.repo.QuestionRepository
import javax.inject.Inject

class QuestionPresenter
@Inject
constructor(private val mSchedulerProvider: SchedulerProvider,
            private val mQuestionRepository: QuestionRepository) : BasePresenter<QuestionContract.View>(), QuestionContract.Presenter {


        var  isInternetAvailable = mQuestionRepository.isInternetAvailable().blockingGet()



    override fun takeView(view: QuestionContract.View) {
        super<BasePresenter>.takeView(view)
        isInternetAvailable()
        initializeAdapter()
    }

    override fun fetchQuestions() {
       if (isInternetAvailable) {
           mCompositeDisposable.add(mQuestionRepository.fetchQuestionOnline()
                   .subscribeOn(mSchedulerProvider.io())
                   .observeOn(mSchedulerProvider.ui())
                   .doOnSubscribe { isInternetAvailable() }
                   .subscribe({
                       mView?.setData(it)
                   }, {
                       it.printStackTrace()
                       mView?.showMessage()
                   }))
       } else {
           mCompositeDisposable.add(mQuestionRepository.loadFromDb()
                   .subscribeOn(mSchedulerProvider.io())
                   .observeOn(mSchedulerProvider.ui())
                   .subscribe({
                       mView?.setData(it)
                   }, {
                       it.printStackTrace()
                       mView?.showMessage()
                   }))
       }
    }

    override fun initializeAdapter() {
        mView?.setUpRecyclerView()
    }

    override fun verifyAnswer() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isInternetAvailable() {
        mCompositeDisposable.add(mQuestionRepository.isInternetAvailable()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe({
                    isInternetAvailable = it
//                    mView?.showError(it)
                },{
                    it.printStackTrace()
                }))
    }

}
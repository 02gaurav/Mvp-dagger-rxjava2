package com.example.apple.mindsharpner.ques

import com.example.apple.mindsharpner.base.BasePresenter
import com.example.apple.mindsharpner.base.SchedulerProvider
import com.example.apple.mindsharpner.repo.QuestionRepository
import javax.inject.Inject

class QuestionPresenter
@Inject
constructor(private val mSchedulerProvider: SchedulerProvider,
            private val mQuestionRepository: QuestionRepository) : BasePresenter<QuestionContract.View>(), QuestionContract.Presenter {

    override fun takeView(view: QuestionContract.View) {
        super<BasePresenter>.takeView(view)
        initializeAdapter()
    }

    override fun fetchQuestions() {
        mCompositeDisposable.add(mQuestionRepository.fetchQuestions()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe({
                    mView?.setData(it)
                },{
                    it.printStackTrace()
                }))
    }

    override fun initializeAdapter() {
        mView?.setUpRecyclerView()
    }

    override fun verifyAnswer() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isInternetAvailable() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
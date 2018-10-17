package com.example.apple.mindsharpner.level

import com.example.apple.mindsharpner.base.BasePresenter
import com.example.apple.mindsharpner.base.SchedulerProvider
import com.example.apple.mindsharpner.repo.LevelRepository
import javax.inject.Inject

class LevelPresenter
@Inject
constructor(private val mLevelRepository: LevelRepository,
            private val mSchedulerProvider: SchedulerProvider) : BasePresenter<LevelContract.View>(), LevelContract.Presenter {
    override fun getAllLevel(){
        mCompositeDisposable.add(mLevelRepository.genrateLevel()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe({
                    mView?.getList(it)
                },{
                    it.printStackTrace()
                }))
    }

}
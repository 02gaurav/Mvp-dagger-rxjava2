package com.example.apple.mindsharpner.data.repository.question

import com.example.apple.mindsharpner.base.SchedulerProvider
import com.example.apple.mindsharpner.data.local.QuestionEntity
import com.example.apple.mindsharpner.data.local.db.AppDatabase
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class QuestionDbHelper
@Inject
constructor(private val mAppDatabase: AppDatabase, private val mSchedulerProvider: SchedulerProvider) {

    private fun insertQuestion(questionEntity: QuestionEntity): Completable = Completable.fromAction { mAppDatabase.questionDao().insert(questionEntity) }

    private fun insertQuestions(questionEntities: List<QuestionEntity>): Completable = Completable.fromAction { mAppDatabase.questionDao().insert(questionEntities) }

    fun insertQuestionAsync(questionEntity: QuestionEntity) {
        insertQuestion(questionEntity)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.io())
                .subscribe()
    }

    fun insertQuestionsAsync(questionEntities: List<QuestionEntity>) {
        insertQuestions(questionEntities)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.io())
                .subscribe()
    }

    fun loadQuestion(quesId: String): Maybe<QuestionEntity> {
        return Maybe.create<QuestionEntity> { emmiter ->
            val question = mAppDatabase.questionDao().loadQuestion(quesId)
            question?.let {
                emmiter.onSuccess(it)
            }
            emmiter.onComplete()
        }
    }

    fun loadAllQuestions() : Single<List<QuestionEntity>> {
        lateinit var questions : List<QuestionEntity>
        return Single.create<List<QuestionEntity>> {
             questions = mAppDatabase.questionDao().loadAllQuestions()
            it.onSuccess(questions)
        }.map {
            questions
        }
    }
}
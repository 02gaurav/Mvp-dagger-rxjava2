package com.example.apple.mindsharpner.repo

import com.example.apple.mindsharpner.data.QuestionEntity
import com.example.apple.mindsharpner.utils.NetworkUtils
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class QuestionRepository
@Inject
constructor(private val mNetworkUtils: NetworkUtils) {

    var list = ArrayList<QuestionEntity>()

    init {
        list.add(QuestionEntity("#323","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
        list.add(QuestionEntity("#231","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
        list.add(QuestionEntity("#455","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
        list.add(QuestionEntity("#768","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
        list.add(QuestionEntity("#123","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
        list.add(QuestionEntity("#654","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
        list.add(QuestionEntity("#345","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
    }

    fun fetchQuestions() : Observable<List<QuestionEntity>> {
        return Observable.create<List<QuestionEntity>>{
            it.onNext(list)
        }

    }

    fun isInternetAvailable() : Single<Boolean> {

        return Single.create<Boolean> {
            it.onSuccess(mNetworkUtils.isConnected)
        }
    }
}
package com.example.apple.mindsharpner.repo

import android.util.Log
import com.example.apple.mindsharpner.data.QuestionContainer
import com.example.apple.mindsharpner.data.local.QuestionEntity
import com.example.apple.mindsharpner.data.remote.services.QuestionService
import com.example.apple.mindsharpner.utils.NetworkUtils
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Single
import org.json.JSONArray
import org.json.JSONException
import javax.inject.Inject
import kotlin.collections.ArrayList

class QuestionRepository
@Inject
constructor(private val mNetworkUtils: NetworkUtils,
            private val mQuestionService: QuestionService,
            private val mGson: Gson) {

    var list = ArrayList<QuestionEntity>()

    init {
//        list.add(QuestionEntity("#323","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
//        list.add(QuestionEntity("#231","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
//        list.add(QuestionEntity("#455","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
//        list.add(QuestionEntity("#768","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
//        list.add(QuestionEntity("#123","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
//        list.add(QuestionEntity("#654","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
//        list.add(QuestionEntity("#345","what is your name", "Aman","Rohit", "Rahul", "Sohan"))
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

    fun fetchQuestionOnline() : Single<List<QuestionEntity>> {
            return mQuestionService.fetchQuestions()
                    .doOnSuccess {
                        Log.e("SUCCESS", "data got successfuly")
                    }
                    .doOnError {
                        it.printStackTrace()
                        Log.e("ERRORFOUND", "error found" + it.printStackTrace())
                    }
    }
}
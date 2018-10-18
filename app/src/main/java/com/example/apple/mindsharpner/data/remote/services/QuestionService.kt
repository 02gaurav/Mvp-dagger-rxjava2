package com.example.apple.mindsharpner.data.remote.services

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET

interface QuestionService {

    @GET("reqQues")
    fun getQuestions(@Body body: ResponseBody) : Single<ResponseBody>
}
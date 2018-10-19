package com.example.apple.mindsharpner.data.remote.services

import com.example.apple.mindsharpner.data.local.QuestionEntity
import io.reactivex.Single
import retrofit2.http.GET

interface QuestionService {

    @GET("/")
    fun fetchQuestions() : Single<List<QuestionEntity>>
}
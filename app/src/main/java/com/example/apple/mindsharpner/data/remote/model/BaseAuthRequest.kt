package com.example.apple.mindsharpner.data.remote.model

import com.example.apple.mindsharpner.data.local.QuestionEntity
import com.google.gson.annotations.SerializedName

data class QuestionResponse(@SerializedName("q") val questions : List<QuestionEntity>)

abstract class BaseRequestBody
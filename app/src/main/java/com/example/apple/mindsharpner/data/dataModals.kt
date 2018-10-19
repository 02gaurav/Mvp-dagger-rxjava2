package com.example.apple.mindsharpner.data

import com.example.apple.mindsharpner.data.local.QuestionEntity

data class TwoNumbers(val number1 : Int, val number2 : Int)

data class Operator(val operator : String)

data class QuestionContainer(val questions: List<QuestionEntity>)
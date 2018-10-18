package com.example.apple.mindsharpner.data

data class TwoNumbers(val number1 : Int, val number2 : Int)

data class Operator(val operator : String)

data class QuestionEntity(
        val quesId :  String,
        val question : String,
        val option1 : String,
        val option2 : String,
        val option3 : String,
        val option4: String,
        val isAnswered : Boolean = false)
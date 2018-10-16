package com.example.apple.mindsharpner.repo

import com.example.apple.mindsharpner.data.TwoNumbers
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject


class NumberRepository
@Inject
constructor() {

    val startVal = 10
    fun genrateTwoNumber() : Observable<TwoNumbers>{
        val number1 = Random().nextInt(100) + startVal
        val number2 = Random().nextInt(10) + startVal
       return Observable.create<TwoNumbers>{
           it.onNext(TwoNumbers(number1, number2))
       }
    }

    fun genrateOperator() : Observable<String>{
        val op = Random().nextInt(4) + 0
        val arr= arrayOf("+", "-", "*", "/")
        return Observable.create<String>{
            it.onNext(arr[op])
        }
    }
 }
package com.example.apple.mindsharpner.repo

import com.example.apple.mindsharpner.data.TwoNumbers
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class NumberRepository
@Inject
constructor() {

        var startVal1 = 10
        var startVal2 = 10
        var bound1 = 0
        var bound2 = 0
        var mlist = ArrayList<String>()
        var arr = arrayOf("+")

    fun genrateTwoNumber(level : Int) : Observable<TwoNumbers>{

        initializeLevelNumber(level)
        val number1 = Random().nextInt(bound1) + startVal1
        val number2 = Random().nextInt(bound2) + startVal1
       return Observable.create<TwoNumbers>{
           it.onNext(TwoNumbers(number1, number2))
       }
    }

    fun genrateOperator(level: Int) : Observable<String>{
        initializeLevelOp(level)
        val op = Random().nextInt(arr.size) + 0
        return Observable.create<String>{
            it.onNext(arr[op])
        }
    }

    private fun initializeLevelNumber(level: Int) {
        when(level) {
            1 -> {
                bound1 = 20
                bound2 = 10
                startVal1 =  20
                startVal2 = 10

            }
            2 -> {
                bound1 = 40
                bound2 = 20
                startVal1 =  20
                startVal2 = 10
            }
            3 -> {
                bound1 = 60
                bound2 = 30
                startVal1 =  20
                startVal2 = 10
            }
            4 -> {
                bound1 = 80
                bound2 = 50
                startVal1 =  20
                startVal2 = 10
            }
            5 -> {
                bound1 = 90
                bound2 = 70
                startVal1 =  20
                startVal2 = 10
            }
            6 -> {
                bound1 = 120
                bound2 = 80
                startVal1 =  20
                startVal2 = 10
            }
            7 -> {
                bound1 = 220
                bound2 = 90
                startVal1 =  20
                startVal2 = 10
            }
            8 -> {
                bound1 = 320
                bound2 = 110
                startVal1 =  20
                startVal2 = 10
            }
            9 -> {
                bound1 = 420
                bound2 = 120
                startVal1 =  20
                startVal2 = 10
            }
            10 -> {
                bound1 = 520
                bound2 = 130
                startVal1 =  20
                startVal2 = 10
            }
        }
    }

    private fun initializeLevelOp(level: Int) {
        if (level <= 3){
            mlist.add("+")
            mlist.add("-")
            val array = arrayOfNulls<String>(mlist.size)
            arr = mlist.toArray(array)
        } else if (level in 4..6) {
            mlist.add("+")
            mlist.add("-")
            mlist.add("*")
            val array = arrayOfNulls<String>(mlist.size)
            arr = mlist.toArray(array)
        } else if (level in 6..10) {
            mlist.add("+")
            mlist.add("-")
            mlist.add("*")
            mlist.add("/")
            val array = arrayOfNulls<String>(mlist.size)
            arr = mlist.toArray(array)
        }
    }
 }
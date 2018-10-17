package com.example.apple.mindsharpner.repo

import android.util.Log
import com.example.apple.mindsharpner.level.data.Levels
import io.reactivex.Observable
import javax.inject.Inject

class LevelRepository
@Inject
constructor() {


    var list = listOf(Levels("1", "#CEAFDC"),
            Levels("2", "#CAA1DC"),
            Levels("3", "#C692DE"),
            Levels("4", "#BE7DDC"),
            Levels("5", "#BD73E0"),
            Levels("6", "#BE6CE3"),
            Levels("7", "#BA60E4"),
            Levels("8", "#B959E6"),
            Levels("9", "#AB3FDE"),
            Levels("10", "#9621CC"))


    fun genrateLevel() : Observable<List<Levels>> {
        return Observable.create<List<Levels>>{
            it.onNext(list)
        }.doOnComplete {
            Log.e("COMPTAG", "this copletes complete")
        }.doOnError {
            Log.e("ERRORTAG", "this copletes error ")
        }
    }
}
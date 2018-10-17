package com.example.apple.mindsharpner.repo

import android.util.Log
import com.example.apple.mindsharpner.level.data.Levels
import io.reactivex.Observable
import javax.inject.Inject

class LevelRepository
@Inject
constructor() {


    var list = listOf(Levels(" Level 1", "#CEAFDC"),
            Levels("Level 2", "#CAA1DC"),
            Levels(" Level 3", "#C692DE"),
            Levels(" Level 4", "#BE7DDC"),
            Levels(" Level 5", "#BD73E0"),
            Levels(" Level 6", "#BE6CE3"),
            Levels(" Level 7", "#BA60E4"),
            Levels(" Level 8", "#B959E6"),
            Levels(" Level 9", "#AB3FDE"),
            Levels(" Level 10", "#9621CC"))


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
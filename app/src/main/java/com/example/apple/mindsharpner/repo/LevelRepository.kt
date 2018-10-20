package com.example.apple.mindsharpner.repo

import android.util.Log
import com.example.apple.mindsharpner.level.data.Levels
import io.reactivex.Observable
import javax.inject.Inject

class LevelRepository
@Inject
constructor() {


    var list = listOf(Levels("1", "#46B1E7"),
            Levels("2", "#E746DD"),
            Levels("3", "#59E746"),
            Levels("4", "#FF5733"),
            Levels("5", "#C70039"),
            Levels("6", "#4663E7"),
            Levels("7", "#C946E7"),
            Levels("8", "#947326"),
            Levels("9", "#945A26"),
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
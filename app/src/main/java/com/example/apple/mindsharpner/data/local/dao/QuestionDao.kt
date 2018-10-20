package com.example.apple.mindsharpner.data.local.dao

import android.arch.persistence.room.*
import com.example.apple.mindsharpner.data.local.QuestionEntity

@Dao
interface QuestionDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(questionEntity : QuestionEntity)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(questionEntityList: List<QuestionEntity>)

    @Query("select * from questions where quesId = :quesId")
    fun loadQuestion(quesId: String): QuestionEntity?

    @Query("select * from questions")
    fun loadAllQuestions() : List<QuestionEntity>

}
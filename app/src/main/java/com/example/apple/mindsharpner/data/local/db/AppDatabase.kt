package com.example.apple.mindsharpner.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.apple.mindsharpner.data.local.QuestionEntity
import com.example.apple.mindsharpner.data.local.dao.QuestionDao

@Database(entities = [QuestionEntity::class],version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun questionDao() : QuestionDao
}
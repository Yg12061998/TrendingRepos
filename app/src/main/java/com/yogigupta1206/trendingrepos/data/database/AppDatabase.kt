package com.yogigupta1206.trendingrepos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yogigupta1206.trendingrepos.data.database.model.repos.Repos

@Database(
    entities = [Repos::class],
    version = 1
)


abstract class AppDatabase : RoomDatabase() {
    abstract fun reposDao(): ReposDao
}
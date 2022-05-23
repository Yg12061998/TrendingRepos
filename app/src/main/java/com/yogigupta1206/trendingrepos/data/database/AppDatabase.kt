package com.yogigupta1206.trendingrepos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yogigupta1206.trendingrepos.data.database.model.repos.Repos
import com.yogigupta1206.trendingrepos.utils.TypeConvertorHelper

@Database(
    entities = [Repos::class],
    version = 1
)

@TypeConverters(TypeConvertorHelper::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reposDao(): ReposDao
}
package com.yogigupta1206.trendingrepos.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.yogigupta1206.trendingrepos.data.database.model.repos.Repos

@Dao
interface ReposDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertAllRepos(repos: List<Repos>)

    @Query("DELETE FROM Repos")
    suspend fun deleteAllRepos()

}
package com.yogigupta1206.trendingrepos.di

import android.content.Context
import androidx.room.Room
import com.yogigupta1206.trendingrepos.data.database.AppDatabase
import com.yogigupta1206.trendingrepos.data.database.ReposDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "TrendingRepoDatabase")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideStoreDao(appDatabase: AppDatabase): ReposDao {
        return appDatabase.reposDao()
    }
}
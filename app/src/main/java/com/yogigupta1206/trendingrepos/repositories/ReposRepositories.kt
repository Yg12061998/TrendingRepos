package com.yogigupta1206.trendingrepos.repositories

import android.content.Context
import android.util.Log
import com.yogigupta1206.trendingrepos.data.database.ReposDao
import com.yogigupta1206.trendingrepos.data.model.repos.Repos
import com.yogigupta1206.trendingrepos.data.network.ApiService
import com.yogigupta1206.trendingrepos.data.network.BaseApiResponse
import com.yogigupta1206.trendingrepos.data.network.NetworkResult
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ReposRepositories @Inject constructor(
    private val apiService: ApiService,
    private val dao: ReposDao,
    @ApplicationContext context: Context
) : BaseApiResponse<Any?>(context){

    suspend fun getReposData(): MutableList<Repos> {
        val data = mutableListOf<Repos>()
        if(isDataAvailable()){
            data.addAll(dao.getAllRepos())
        }else{
            getDataOnline()?.let {
                data.addAll(it)
            }
        }
        return data
    }

    private suspend fun isDataAvailable(): Boolean {
        if(dao.findCount() > 0)
            return true
        return false
    }

    suspend fun getDataOnline(): ArrayList<Repos>? {
        return when(val testData = getDataFromNetwork()){
            is NetworkResult.Success ->{
                testData.responseData?.let {
                    dao.deleteAllRepos()
                    dao.insertAllRepos(it)
                }
                testData.responseData
            }
            else -> {
                ArrayList()
            }
        }
    }

    private suspend fun getDataFromNetwork() : NetworkResult<ArrayList<Repos>> = safeApiCall { apiService.getProfiles() }

}
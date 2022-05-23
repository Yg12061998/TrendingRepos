package com.yogigupta1206.trendingrepos.repositories

import android.content.Context
import com.yogigupta1206.trendingrepos.data.network.ApiService
import com.yogigupta1206.trendingrepos.data.network.BaseApiResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ReposRepositories @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext context: Context
) : BaseApiResponse<Any?>(context){
}
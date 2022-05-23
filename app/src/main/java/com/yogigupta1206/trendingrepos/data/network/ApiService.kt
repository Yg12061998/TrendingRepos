package com.yogigupta1206.trendingrepos.data.network

import com.yogigupta1206.trendingrepos.data.database.model.repos.Repos
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/repositories?language=&since=daily&spoken_language_code=")
    suspend fun getProfiles(): Response<ArrayList<Repos>>

}

package com.johnmoraleslo.appfutbol.data.remote

import com.johnmoraleslo.appfutbol.data.model.TeamResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApi {
    @GET("search_all_teams.php")
    suspend fun getTeams(
        @Query("l") league: String = "Spanish La Liga"
    ): TeamResponse

    @GET("searchteams.php")
    suspend fun searchTeams(
        @Query("t") name: String
    ): TeamResponse

    @GET("lookupteam.php")
    suspend fun getTeamById(
        @Query("id") id: Int
    ): TeamResponse
}

object RetrofitClient {
    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/"

    val api: FootballApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballApi::class.java)
    }
}

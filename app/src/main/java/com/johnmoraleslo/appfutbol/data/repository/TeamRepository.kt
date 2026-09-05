package com.johnmoraleslo.appfutbol.data.repository

import com.johnmoraleslo.appfutbol.data.model.FootballTeam
import com.johnmoraleslo.appfutbol.data.remote.RetrofitClient

class TeamRepository {

    private val api = RetrofitClient.api

    suspend fun getTeams(): Result<List<FootballTeam>> {
        return try {
            val response = api.getTeams()
            Result.success(response.teams)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

package com.johnmoraleslo.appfutbol.data.repository

import com.johnmoraleslo.appfutbol.data.model.FootballTeam
import com.johnmoraleslo.appfutbol.data.remote.RetrofitClient

class TeamRepository {

    private val api = RetrofitClient.api

    suspend fun getTeams(name: String? = null): Result<List<FootballTeam>> {
        return try {
            val response = if (name.isNullOrBlank()) {
                api.getTeams()
            } else {
                api.searchTeams(name)
            }
            Result.success(response.teams ?: emptyList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

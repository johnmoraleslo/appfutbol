package com.johnmoraleslo.appfutbol.data.model

data class TeamResponse(
    val teams: List<FootballTeam>
)

data class FootballTeam(
    val idTeam: String,
    val strTeam: String,
    val strLeague: String,
    val strCountry: String,
    val strStadium: String,
    val strBadge: String
)

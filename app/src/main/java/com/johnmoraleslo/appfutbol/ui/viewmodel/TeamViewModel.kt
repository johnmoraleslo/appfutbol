package com.johnmoraleslo.appfutbol.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnmoraleslo.appfutbol.data.model.FootballTeam
import com.johnmoraleslo.appfutbol.data.repository.TeamRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

sealed interface TeamUiState {
    object Loading : TeamUiState
    data class Success(val teams: List<FootballTeam>) : TeamUiState
    data class Error(val message: String) : TeamUiState
}

@OptIn(FlowPreview::class)
class TeamViewModel : ViewModel() {
    private val repository = TeamRepository()

    private val _uiState = MutableStateFlow<TeamUiState>(TeamUiState.Loading)
    val uiState: StateFlow<TeamUiState> = _uiState

    // Estado del query de búsqueda
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    init {
        // Escucha cambios en la búsqueda con debounce para evitar spam de llamadas HTTP
        _searchQuery
            .debounce(300L)
            .distinctUntilChanged()
            .onEach { query -> fetchTeams(query) }
            .launchIn(viewModelScope)
    }

    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
    }

    private fun fetchTeams(query: String = "") {
        viewModelScope.launch {
            _uiState.value = TeamUiState.Loading
            repository.getTeams(name = query.ifBlank { null })
                .onSuccess { list ->
                    _uiState.value = TeamUiState.Success(list)
                }
                .onFailure {
                    _uiState.value = TeamUiState.Error("No se encontraron resultados")
                }
        }
    }
}

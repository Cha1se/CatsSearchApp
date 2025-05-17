package com.cha1se.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cha1se.domain.repository.Repository
import com.cha1se.domain.util.Result
import com.cha1se.presentation.viewmodels.events.MainEvent
import com.cha1se.presentation.viewmodels.state.MainState
import com.cha1se.presentation.viewmodels.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.loadData -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.loadCats(10, 1).collect { cats ->
                        when(cats) {
                            is Result.Success -> {
                                _state.update { it.copy(catList = cats.data) }
                                _uiState.update { it.copy(isLoading = false, isError = false) }
                            }
                            is Result.Error -> {
                                _uiState.update { it.copy(isLoading = false, isError = true) }
                            }
                            is Result.Loading -> {
                                _uiState.update { it.copy(isLoading = true, isError = false) }
                            }
                        }
                    }
                }
            }
        }
    }



}
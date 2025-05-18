package com.cha1se.presentation.viewmodels.events

sealed class MainEvent {
    data class loadData(val query: String = " "): MainEvent()

}
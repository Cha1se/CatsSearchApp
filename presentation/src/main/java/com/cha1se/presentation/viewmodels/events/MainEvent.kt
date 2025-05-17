package com.cha1se.presentation.viewmodels.events

sealed class MainEvent {
    data object loadData: MainEvent()

}
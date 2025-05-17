package com.cha1se.presentation.navigation

sealed class Screen(val name: String) {

    data object Home: Screen("home")
}
package com.cha1se.presentation.navigation

sealed class Screen(val route: String) {

    data object Home: Screen("home")
    data object Info: Screen("info/{id}") {
        fun routeWithArgument(id: String) = Info.route.replace("{id}", id)
    }
}
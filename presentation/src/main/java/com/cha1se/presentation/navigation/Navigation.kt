package com.cha1se.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cha1se.presentation.screens.MainScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.name) {

        composable(Screen.Home.name) { MainScreen(navController) }

    }
}
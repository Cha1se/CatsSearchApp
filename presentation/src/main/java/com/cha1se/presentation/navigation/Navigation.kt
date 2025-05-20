package com.cha1se.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cha1se.presentation.screens.AboutScreen
import com.cha1se.presentation.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) { MainScreen(navController) }

        composable(route = Screen.Info.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            AboutScreen(navController = navController, id = id)
        }
    }

}
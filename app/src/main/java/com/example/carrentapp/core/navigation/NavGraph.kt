package com.example.carrentapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carrentapp.ui.home.HomeScreen
import com.example.carrentapp.ui.home.NavigateToHome

@Composable
internal fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            NavigateToHome()
        }

        composable(route = Screen.Car.route) {
        }

        composable(route = Screen.Map.route) {
        }

        composable(route = Screen.User.route) {
        }

    }
}
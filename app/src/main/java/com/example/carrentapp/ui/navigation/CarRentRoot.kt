package com.example.carrentapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.carrentapp.ui.theme.backgroungColor

@Composable
fun CarRentRoot() {

    // Navigation
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        Modifier.padding(it)
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            NavGraph(
                navController = navController,
            )
        }
    }
}
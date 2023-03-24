package com.example.carrentapp.core.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.carrentapp.data.local.repository.CarRepository
import com.example.carrentapp.ui.presentation.CarListViewModel
import com.example.carrentapp.ui.presentation.CarViewModelFactory
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
package com.example.carrentapp.ui.navigation

import com.example.carrentapp.R

sealed class Screen(
    val route: String,
    val title: String? = null,
    val icon: Int? = null,
    val iconFocused: Int? = null,
){
    object Home : Screen(
        route = Routes.HOME,
        title = "Home",
        icon = R.drawable.u_home,
        iconFocused = R.drawable.u_home_selected
    )

    object Car : Screen(
        route = Routes.CAR,
        title = "Car",
        icon = R.drawable.u_car,
        iconFocused = R.drawable.u_car_selected
    )

    object Map : Screen(
        route = Routes.MAP,
        title = "Map",
        icon = R.drawable.u_map,
    )

    object User : Screen(
        route = Routes.USER,
        title = "User",
        icon = R.drawable.u_user,
    )
}
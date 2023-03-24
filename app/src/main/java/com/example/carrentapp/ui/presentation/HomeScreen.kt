package com.example.carrentapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carrentapp.R
import com.example.carrentapp.ui.components.AppButtons
import com.example.carrentapp.data.local.entity.CarEntity
import com.example.carrentapp.data.local.entity.VehicleTypeEntity
import com.example.carrentapp.data.local.repository.CarRepository
import com.example.carrentapp.core.navigation.TopNavBar
import com.example.carrentapp.ui.presentation.CarListViewModel
import com.example.carrentapp.ui.presentation.CarViewModelFactory
import com.example.carrentapp.ui.theme.*


@Composable
fun NavigateToHome() {

    val context = LocalContext.current
    val carRepository = remember { CarRepository(context) }
    val carViewModel = viewModel<CarListViewModel>(factory = CarViewModelFactory(carRepository))

    val carState by carViewModel.allCars.collectAsState(initial = emptyList())
    val vehicleTypeState by carViewModel.allVehicleTypes.collectAsState(initial = emptyList())


    HomeScreen(
        carState = carState,
        vehicleTypeState = vehicleTypeState
    )
}

//TODO use string resource instead of hardcoded Strings

@Composable
fun HomeScreen(
    carState: List<CarEntity>,
    vehicleTypeState: List<VehicleTypeEntity>
) {
    Column(
        modifier = Modifier
            .background(backgroungColor)
            .fillMaxSize()
            .padding(top = 16.dp, start = 32.dp, end = 32.dp)
    ) {
        TopNavBar()
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Searchbar(text = "",
                onTextChange = {},
                onClearClick = { /*TODO*/ })
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyRow(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(vehicleTypeState) { vehicleType ->
                    AppButtons.OutlinedBorderButton(
                        title = vehicleType.type,
                        icon = R.drawable.white_cross,
                        onClick = {}
                    )
                }
            })


        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Near You",
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(
                        resId = R.font.outfit_bold,
                        weight = FontWeight.Bold,
                    ),
                ),
            )
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "See on map",
                    fontSize = 14.sp,
                    color = LinkColor,
                    fontFamily = FontFamily(
                        Font(
                            resId = R.font.outfit,
                            weight = FontWeight.Bold,
                        ),
                    ),
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Driver available",
                fontSize = 16.sp,
                color = fontDarkColor,
                fontFamily = FontFamily(
                    Font(
                        resId = R.font.outfit_semi_bold,
                        weight = FontWeight.Normal,
                    ),
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(carState) { carItem ->
                    CarItemCard(car = carItem)
                }
            })
    }
}
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carrentapp.R
import com.example.carrentapp.ui.components.AppButtons
import com.example.carrentapp.ui.data.model.Car
import com.example.carrentapp.ui.data.model.CarImages
import com.example.carrentapp.ui.data.model.VehicleType
import com.example.carrentapp.ui.theme.backgroungColor
import com.example.carrentapp.ui.theme.buttonShape


@Composable
fun NavigateToHome() {
    HomeScreen(
        cars = listOf(
            Car(
                brand = "BMW",
                model = "M3",
                costPerDay = 100,
                logo = R.drawable.bwm_logo,
                carImages = CarImages(thumbail = painterResource(id = R.drawable.bmw_thumbnail)),
                isAvailable = true
            ),
            Car(
                brand = "BMW",
                model = "M3",
                costPerDay = 100,
                logo = R.drawable.bwm_logo,
                carImages = CarImages(thumbail = painterResource(id = R.drawable.bmw_thumbnail)),
                isAvailable = true
            ),

            Car(
                brand = "BMW",
                model = "M3",
                costPerDay = 100,
                logo = R.drawable.bwm_logo,
                carImages = CarImages(thumbail = painterResource(id = R.drawable.bmw_thumbnail)),
                isAvailable = true
            ),

            Car(
                brand = "BMW",
                model = "M3",
                costPerDay = 100,
                logo = R.drawable.bwm_logo,
                carImages = CarImages(thumbail = painterResource(id = R.drawable.bmw_thumbnail)),
                isAvailable = true
            )
        ),
        vehicleType = VehicleType(type = listOf("Luxury","Mini Van", "Truck","Limo"))
    )
}

@Composable
fun HomeScreen(
    cars: List<Car>,
    vehicleType: VehicleType
) {
    Column(
        modifier = Modifier
            .background(backgroungColor)
            .fillMaxSize()
            .padding(top = 16.dp, start = 32.dp, end = 32.dp)
    ) {

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
            content = {
                val vehicleTypes = vehicleType.type
                items(vehicleTypes) { vehicleType ->
                    AppButtons.OutlinedBorderButton(
                        title = vehicleType,
                        icon = R.drawable.cross,
                        onClick = {}
                    )
                }
            })

//        Row(modifier = Modifier.fillMaxWidth()) {
//            AppButtons.OutlinedBorderButton(
//                title = "Truck",
//                icon = R.drawable.cross,
//                onClick = {})
//        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Near You")
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "See on map")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Driver available")

        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(cars) { carItem ->
                    CarItemCard(car = carItem)
                }
            })

//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2)
//        ) {
//           content = {
//
//           }
//            val carMockupData = Car(
//                brand = "BMW",
//                model = "M3",
//                costPerDay = 100,
//                logo = R.drawable.bwm_logo,
//                carImages = CarImages(thumbail = painterResource(id = R.drawable.bmw_thumbnail)),
//                isAvailable = tru
//            )
//
//            CarItemCard(car = carMockupData, navController = navController)

    }
}

@Composable
fun OutlinedIconButton(
    title: String,
    icon: Int? = null,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.buttonShape,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
        ),
    ) {
        Box(
            modifier = Modifier
                .height(36.dp)
                .width(104.dp)
                .background(
                    color = Color.Transparent,
                    shape = MaterialTheme.shapes.buttonShape,
                ),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.button,
                color = Color.Gray,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.width(8.dp))

            icon?.let {
                Icon(
                    painter = painterResource(it),
                    modifier = Modifier.align(Alignment.CenterEnd),
                    contentDescription = "",
                )
            }
        }
    }
}

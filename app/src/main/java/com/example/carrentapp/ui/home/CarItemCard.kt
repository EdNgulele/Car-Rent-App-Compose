package com.example.carrentapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.carrentapp.R
import com.example.carrentapp.ui.data.model.Car
import com.example.carrentapp.ui.data.model.CarImages
import com.example.carrentapp.ui.theme.carCardShape
import com.example.carrentapp.ui.theme.searchBarShape


@Composable
fun CarItemCard(
    car: Car,
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(220.dp)
            .padding(8.dp)
            .background(
                color = Color.White,
                shape = MaterialTheme.shapes.carCardShape
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .width(146.dp)
                    .heightIn(72.dp)
                    .padding(start = 5.dp, top = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                val painter = car.carImages.thumbail
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = car.brand)
                Image(
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(car.logo),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Row() {
                    Text(text = "$ ${car.costPerDay}")
                    Text(text = "/Day")
                }

                Spacer(modifier = Modifier.width(50.dp))

                Image(
                    painter = painterResource(id = R.drawable.arrow_button),
                    contentDescription = null,
                    modifier = Modifier
                        .height(36.dp)
                        .width(36.dp),
                )


            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun CarItemCardPreview() {
    val carMockupData = Car(
        brand = "BMW",
        model = "M3",
        costPerDay = 100,
        logo = R.drawable.bwm_logo,
        carImages = CarImages(thumbail = painterResource(id = R.drawable.bmw_thumbnail)),
        isAvailable = true

    )

    CarItemCard(car = carMockupData)
}
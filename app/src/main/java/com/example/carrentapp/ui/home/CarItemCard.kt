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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carrentapp.R
import com.example.carrentapp.ui.data.model.Car
import com.example.carrentapp.ui.data.model.CarImages
import com.example.carrentapp.ui.theme.carCardShape
import com.example.carrentapp.ui.theme.fontDarkColor
import com.example.carrentapp.ui.theme.fontGreyColor
import com.example.carrentapp.ui.theme.searchBarShape


@Composable
fun CarItemCard(
    car: Car,
) {
    Box(
        modifier = Modifier
            .width(220.dp)
            .height(200.dp)
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
                val thumbnailPainter = painterResource(id = car.carImages.thumbnailResourceId)

                Image(
                    painter = thumbnailPainter,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .aspectRatio(ratio = thumbnailPainter.intrinsicSize.width / thumbnailPainter.intrinsicSize.height)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end =12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = car.brand,
                    fontSize = 16.sp,
                    color = fontDarkColor,
                    fontFamily = FontFamily(
                        Font(
                            resId = R.font.outfit_semi_bold,
                            weight = FontWeight.Normal,
                        ),
                    )
                )
                Image(
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    painter = painterResource(car.logo),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(text = "$ ${car.costPerDay}",
                        fontSize = 16.sp,
                        color = fontDarkColor,
                        fontFamily = FontFamily(
                            Font(
                                resId = R.font.outfit_semi_bold,
                                weight = FontWeight.Normal,
                            ),
                        ))
                    Text(text = "/Day",
                        fontSize = 12.sp,
                        color = fontGreyColor,
                        fontFamily = FontFamily(
                            Font(
                                resId = R.font.outfit_semi_bold,
                                weight = FontWeight.Normal,
                            ),
                        ))
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
        carImages = CarImages(thumbnailResourceId= R.drawable.bmw_thumbnail),
        isAvailable = true

    )

    CarItemCard(car = carMockupData)
}
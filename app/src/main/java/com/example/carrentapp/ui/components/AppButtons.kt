package com.example.carrentapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrentapp.R
import com.example.carrentapp.core.Dimensions
import com.example.carrentapp.ui.components.AppButtons.OutlinedBorderButton
import com.example.carrentapp.ui.theme.BorderColor
import com.example.carrentapp.ui.theme.buttonShape

object AppButtons {

    @Composable
    fun OutlinedBorderButton(
        modifier: Modifier = Modifier,
        title: String,
        icon: Int? = null,
        onClick: () -> Unit,
    ) {
        OutlinedButton(
            onClick = onClick,
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
            ),
            shape = MaterialTheme.shapes.buttonShape,
        ) {
            Box(
                modifier = modifier
                    .height(36.dp)
                    .width(104.dp)
                    .background(
                        color = Color.Transparent,
                        shape = MaterialTheme.shapes.buttonShape,
                    ),
            ) {

                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.button,
                        color = Color.Gray,
                        fontSize = 16.sp,
                    )

                    icon?.let {
                        Icon(
                            painter = painterResource(it),
                            contentDescription = "",
                        )
                    }
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OutlinedButtonPreview() {
    OutlinedBorderButton(
        title = "Truck",
        icon = R.drawable.cross,
        onClick = {}
    )
}
package com.example.carrentapp.core.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carrentapp.R

@Composable
internal fun TopNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier  = Modifier
                .height(36.dp)
                .width(36.dp),
            painter = painterResource(id = R.drawable.hamburguer),
            contentDescription = null
        )

        Image(
            modifier  = Modifier
                .height(36.dp)
                .width(36.dp),
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TopNavBarPreview() {
    TopNavBar()
}
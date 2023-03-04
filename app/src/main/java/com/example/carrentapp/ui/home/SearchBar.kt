package com.example.carrentapp.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.carrentapp.ui.theme.TextInputBackground
import com.example.carrentapp.ui.theme.searchBarShape


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carrentapp.R
import com.example.carrentapp.ui.theme.PlaceholderColor

@Composable
fun Searchbar(
    text: String,
    onTextChange: (String) -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier,
    primary: Boolean = false,
) {
    val isFocused = remember {
        mutableStateOf(false)
    }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier
            .background(
                if (primary || isFocused.value) MaterialTheme.colors.background else Color.White,
                MaterialTheme.shapes.searchBarShape
            )
            .fillMaxWidth()
            .padding(start = 8.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.u_search),
            contentDescription = "Search",
            tint = Color.Unspecified,
        )
        BasicTextField(
            value = text,
            onValueChange = onTextChange,
            textStyle = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.0f)
                .padding(all = 0.dp)
                .onFocusChanged { focusState ->
                    isFocused.value = focusState.isFocused
                },
            singleLine = true,
            maxLines = 1,
            cursorBrush = SolidColor(MaterialTheme.colors.primary),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .padding(horizontal = 0.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 8.dp)
                        .focusRequester(focusRequester),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (!isFocused.value && text.isBlank()) {
                        Text(
                            text = "Rent my car",
                            style = MaterialTheme.typography.subtitle2,
                            color = PlaceholderColor,
                        )
                    }
                    innerTextField()
                }
            },
        )
        AnimatedVisibility(
            visible = text.isBlank(),
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Spacer(modifier = Modifier.width(24.dp))
        }
        AnimatedVisibility(
            visible = text.isNotBlank(),
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Icon(
                painter = painterResource(R.drawable.cross),
                contentDescription = "Clear",
                tint = Color.Unspecified,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable {
                        onClearClick()
                        focusManager.clearFocus()
                    },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview(){
    Searchbar(text = "",
        onTextChange ={} , onClearClick = { /*TODO*/ })
}

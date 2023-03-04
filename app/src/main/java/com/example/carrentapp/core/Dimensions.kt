package com.example.carrentapp.core

import android.annotation.SuppressLint
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.content.Context
import com.example.carrentapp.R


@SuppressLint("StaticFieldLeak")
object Dimensions {
    lateinit var context: Context

    fun defaultBorderWidth(): Dp = context.resources.getInteger(R.integer.width_border_default).dp
    fun buttonHeight(): Dp = context.resources.getInteger(R.integer.height_button).dp
    fun buttonHorizontalPadding(): Dp = context.resources.getInteger(R.integer._14).dp
    fun buttonVerticalPadding(): Dp = context.resources.getInteger(R.integer._16).dp

}
package com.cha1se.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.cha1se.presentation.R

val Roboto = FontFamily(Font(R.font.roboto))
val RobotoMedium = FontFamily(Font(R.font.roboto_medium))

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = Roboto,
        fontSize = 14.sp,
        color = Color.White,
    ),
    bodyLarge = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        color = Color.White,
    ),

    labelLarge = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 16.sp,
        color = Color.White,
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 14.sp,
        color = Color.White,
    ),

    titleMedium = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 14.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    ),
)
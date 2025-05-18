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
val FigTreeBlack = FontFamily(Font(R.font.figtree_black))
val FigTreeBold = FontFamily(Font(R.font.figtree_bold))

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = Roboto,
        fontSize = 14.sp,
        color = OnSurface,
    ),
    bodyLarge = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        color = OnSurface,
    ),
    bodySmall = TextStyle(
        fontFamily = Roboto,
        fontSize = 14.sp,
        color = OnSurfaceVar,
    ),

    labelLarge = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 16.sp,
        color = Primary,
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 14.sp,
        color = Primary,
    ),

    titleMedium = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 14.sp,
        color = Primary,
        textAlign = TextAlign.Center
    ),
    titleLarge = TextStyle(
        fontFamily = FigTreeBlack,
        fontSize = 26.sp,
        letterSpacing = 1.5.sp,
        color = Primary,
    ),
)
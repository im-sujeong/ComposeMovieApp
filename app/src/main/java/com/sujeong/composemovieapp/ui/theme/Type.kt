package com.sujeong.composemovieapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sujeong.composemovieapp.R

val pretendardFontFamily = FontFamily(
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    headlineSmall = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    titleMedium = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 12.sp
    ),
    labelLarge = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 12.sp
    )
)

val Typography.bodyMediumLineHeight30: TextStyle
    @Composable get() = bodyMedium.copy(
        lineHeight = 30.sp
    )

val Typography.bodyLargeLineHeight20: TextStyle
    @Composable get() = bodyLarge.copy(
        lineHeight = 20.sp
    )

val Typography.labelSmallProminent: TextStyle
    @Composable get() = labelSmall.copy(
        fontWeight = FontWeight.Medium
    )

val Typography.button: TextStyle
    @Composable get() = titleLarge

val Typography.buttonSmall: TextStyle
    @Composable get() = bodyLarge
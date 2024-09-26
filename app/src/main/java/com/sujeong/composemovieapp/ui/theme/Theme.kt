package com.sujeong.composemovieapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalColors = staticCompositionLocalOf {
    LightColorScheme
}

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    onPrimary = White,
    secondary = Gray,
    onSecondary = White,
    background = DarkGray,
    onBackground = LightGray,
    surfaceVariant = LightGray
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = White,
    secondary = Gray,
    onSecondary = White,
    background = White,
    onBackground = DarkGray,
    surfaceVariant = LightGray
)

@Composable
fun ComposeMovieAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: Typography = Typography,
    shapes: Shapes = Shapes,
    content: @Composable () -> Unit
) {
    val colorScheme = if(darkTheme) {
        DarkColorScheme
    }else {
        LightColorScheme
    }

    CompositionLocalProvider(
        LocalColors provides colorScheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}
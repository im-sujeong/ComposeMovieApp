package com.sujeong.composemovieapp.features.detail.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MovieDetailScreen(
    onGoBack: () -> Unit
) {
    Text(text = "영화 정보 상세")
}
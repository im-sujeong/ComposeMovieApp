package com.sujeong.composemovieapp.ui.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.button
import com.sujeong.composemovieapp.ui.theme.buttonSmall
import com.sujeong.composemovieapp.ui.theme.huge

@Composable
private fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textStyle: TextStyle,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.huge,
        contentPadding = PaddingValues(
            horizontal = 24.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
fun PrimaryButtonLarge(
    modifier: Modifier = Modifier,
    @StringRes textId: Int? = null,
    text: String = "",
    onClick: () -> Unit
) {
    PrimaryButton(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        text = textId?.let { stringResource(id = it) } ?: text,
        textStyle = MaterialTheme.typography.button,
        onClick = onClick
    )
}

@Composable
fun PrimaryButtonSmall(
    modifier: Modifier = Modifier,
    @StringRes textId: Int? = null,
    text: String = "",
    onClick: () -> Unit
) {
    PrimaryButton(
        modifier = modifier
            .height(32.dp),
        text = textId?.let { stringResource(id = it) } ?: text,
        textStyle = MaterialTheme.typography.buttonSmall,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    ComposeMovieAppTheme {
        Column {
            PrimaryButtonLarge(
                text = "테스트"
            ) {

            }

            PrimaryButtonSmall(
                text = "작은 버튼"
            ) {

            }
        }
    }
}
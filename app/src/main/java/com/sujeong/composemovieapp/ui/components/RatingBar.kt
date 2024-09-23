package com.sujeong.composemovieapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float = 0.0f,
    @DrawableRes checkedIcon: Int = R.drawable.ic_star_40dp,
    @DrawableRes halfIcon: Int = R.drawable.ic_star_half_40dp,
    @DrawableRes unCheckedIcon: Int = R.drawable.ic_star_off_40dp,
    stars: Int = 5,
    checkedColor: Color = MaterialTheme.colorScheme.primary,
    onRatingChanged: (Float) -> Unit = {}
) {
    Row(
        modifier = modifier
    ) {
        for (i in 1 .. stars) {
            Icon(
                modifier = Modifier
                    .clickable {
                        onRatingChanged(i.toFloat())
                    },
                imageVector = if(rating >= i) {
                    ImageVector.vectorResource(id = checkedIcon)
                }else {
                    if(rating == 0f || rating <= i - 1) {
                        ImageVector.vectorResource(id = unCheckedIcon)
                    }else {
                        ImageVector.vectorResource(id = halfIcon)
                    }
                },
                contentDescription = "",
                tint = checkedColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RatingBarPreview() {
    ComposeMovieAppTheme {
        RatingBar(
            rating = 1f
        )
    }
}
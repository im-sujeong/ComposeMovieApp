package com.sujeong.composemovieapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float,
    @DrawableRes checkedIcon: Int = R.drawable.ic_star_40dp,
    @DrawableRes halfIcon: Int = R.drawable.ic_star_half_40dp,
    @DrawableRes unCheckedIcon: Int = R.drawable.ic_star_off_40dp,
    stars: Int = 5,
    starSize: Dp = 40.dp,
    checkedColor: Color = MaterialTheme.colorScheme.primary,
    onRatingChanged: (Float) -> Unit = {},
    clickable: Boolean = true
) {
    var ratingState by remember {
        mutableFloatStateOf(rating)
    }

    Row(
        modifier = modifier
    ) {
        for (i in 1 .. stars) {
            Icon(
                modifier = Modifier
                    .size(starSize)
                    .clickable(
                        enabled = clickable
                    ) {
                        ratingState = i.toFloat()

                        onRatingChanged(i.toFloat())
                    },
                imageVector = if(ratingState >= i) {
                    ImageVector.vectorResource(id = checkedIcon)
                }else {
                    if(ratingState == 0f || ratingState <= i - 1) {
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
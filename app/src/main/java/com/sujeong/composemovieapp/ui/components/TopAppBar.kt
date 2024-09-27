package com.sujeong.composemovieapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.feed.presentation.input.FeedViewModelInput
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    navigation: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(start = Paddings.padding8),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            navigation()

            title()
        }

        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            actions()

            Spacer(modifier = Modifier.width(Paddings.padding16))
        }
    }
}

@Composable
fun TopAppBarWithBack(
    modifier: Modifier = Modifier,
    title: String? = null,
    actions: @Composable RowScope.() -> Unit = {},
    onBack: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        navigation = {
            Spacer(modifier = Modifier.width(Paddings.padding8))

            IconButton(
                modifier = Modifier
                    .size(40.dp),
                onClick = onBack
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                    contentDescription = "뒤로 가기",
                )
            }
        },
        title = {
            if (title != null) {
                Text(
                    modifier = Modifier.padding(start = Paddings.padding8),
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        actions = actions
    )
}

@Composable
fun TopAppBarForFeed(
    modifier: Modifier = Modifier,
    input: FeedViewModelInput? = null
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Icon(
                modifier = Modifier.padding(start = Paddings.padding16),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_app_logo),
                contentDescription = "앱 로고"
            )
        },
        actions = {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {
                    input?.changeTheme()
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_change_theme),
                    contentDescription = "테마 변경",
                )
            }

            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {
                    input?.openAppInfo()
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_app_info),
                    contentDescription = "앱 정보",
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview1() {
    ComposeMovieAppTheme {
        TopAppBarForFeed()
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview2() {
    ComposeMovieAppTheme {
        TopAppBarWithBack(
            title = "인기"
        ) { }
    }
}
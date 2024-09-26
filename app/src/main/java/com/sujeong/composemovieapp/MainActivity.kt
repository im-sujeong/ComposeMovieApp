package com.sujeong.composemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.sujeong.composemovieapp.features.common.presentation.util.AppInfoDialogRoute
import com.sujeong.composemovieapp.features.common.presentation.util.MovieDetailRoute
import com.sujeong.composemovieapp.features.common.presentation.util.MovieFeedRoute
import com.sujeong.composemovieapp.features.common.presentation.util.MovieRatingDialogRoute
import com.sujeong.composemovieapp.features.detail.presentation.MovieDetailScreen
import com.sujeong.composemovieapp.features.dialogs.appinfo.AppInfoDialogScreen
import com.sujeong.composemovieapp.features.dialogs.rating.MovieRatingDialogScreen
import com.sujeong.composemovieapp.features.feed.presentation.FeedScreen
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkTheme = isSystemInDarkTheme()

            var darkThemeState by remember {
                mutableStateOf(isDarkTheme)
            }

            ComposeMovieAppTheme(
                darkTheme = darkThemeState
            ) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = MovieFeedRoute
                ) {
                    composable<MovieFeedRoute> {
                        FeedScreen(
                            onChangeTheme = {
                                darkThemeState = !darkThemeState
                            },
                            onNavigationToMovieDetail = { movieId ->
                                navController.navigate(
                                    MovieDetailRoute(movieId)
                                )
                            },
                            onNavigationToAppInfoDialog = {
                                navController.navigate(
                                    AppInfoDialogRoute
                                )
                            }
                        )
                    }

                    composable<MovieDetailRoute> {
                        MovieDetailScreen(
                            onGoBack = {
                                navController.navigateUp()
                            },
                            onNavigationToMovieRatingDialog = { movieId ->
                                navController.navigate(
                                    MovieRatingDialogRoute(movieId)
                                )
                            }
                        )
                    }

                    dialog<AppInfoDialogRoute> {
                        AppInfoDialogScreen(
                            onDismiss = {
                                navController.navigateUp()
                            }
                        )
                    }

                    dialog<MovieRatingDialogRoute> {
                        MovieRatingDialogScreen(
                            onDismiss = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    }
}

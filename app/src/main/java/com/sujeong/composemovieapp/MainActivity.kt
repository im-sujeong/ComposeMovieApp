package com.sujeong.composemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.sujeong.composemovieapp.features.common.presentation.util.AppInfoDialogRoute
import com.sujeong.composemovieapp.features.common.presentation.util.MovieDetailRoute
import com.sujeong.composemovieapp.features.common.presentation.util.MovieFeedRoute
import com.sujeong.composemovieapp.features.detail.presentation.MovieDetailScreen
import com.sujeong.composemovieapp.features.dialogs.AppInfoDialogScreen
import com.sujeong.composemovieapp.features.feed.presentation.FeedScreen
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMovieAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = MovieFeedRoute,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<MovieFeedRoute> {
                            FeedScreen(
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
                    }
                }
            }
        }
    }
}

package com.sujeong.composemovieapp.features.common.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sujeong.composemovieapp.features.common.data.mapper.toMovie
import com.sujeong.composemovieapp.features.common.data.network.api.MovieApi
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory

class MovieByCategoryPagingSource(
    private val movieApi: MovieApi,
    private val movieCategory: MovieCategory
): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return  state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1

        try {
            val response = when(movieCategory) {
                MovieCategory.POPULAR -> movieApi.fetchPopularMovies(page)
                MovieCategory.NOW_PLAYING -> movieApi.fetchNowPlayingMovies(page)
                MovieCategory.UPCOMING -> movieApi.fetchUpcomingMovies(page)
                MovieCategory.TOP_RATED -> movieApi.fetchTopRatedMovies(page)
            }

            val result = response.results.map {
                it.toMovie()
            }

            return LoadResult.Page(
                data = result,
                prevKey = null,
                nextKey = if(response.totalPages == page) {
                    null
                }else {
                    page + 1
                }
            )
        }catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}
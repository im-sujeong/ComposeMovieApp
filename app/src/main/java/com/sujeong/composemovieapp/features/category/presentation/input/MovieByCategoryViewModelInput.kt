package com.sujeong.composemovieapp.features.category.presentation.input

interface MovieByCategoryViewModelInput {
    fun openMovieDetail(movieId: Int)
    fun goBack()
    fun scrollToTop()
}
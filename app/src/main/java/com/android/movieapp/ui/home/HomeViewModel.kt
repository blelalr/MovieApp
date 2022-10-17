package com.android.movieapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.movieapp.data.model.MovieData
import com.android.movieapp.data.repo.MovieRepo
import kotlinx.coroutines.flow.Flow


class HomeViewModel(private val movieRepo: MovieRepo = MovieRepo()) : ViewModel() {
    private var nowPlayingPageResult: Flow<PagingData<MovieData>>? = null

//    private var tabSelectedPosition = MutableLiveData<Int>()

    fun getMoviesByTabPosition(position: Int): Flow<PagingData<MovieData>> {
        val newResult: Flow<PagingData<MovieData>> = movieRepo.getNowPlaying(position)
            .cachedIn(viewModelScope)
        nowPlayingPageResult = newResult
        return newResult
    }

//    fun setTabSelectedPosition(position: Int) {
//        tabSelectedPosition.value = position
//    }
//
//    fun getTabSelectPosition(): LiveData<Int> {
//        return tabSelectedPosition
//    }

}
package com.android.movieapp.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.movieapp.data.model.MovieData
import kotlinx.coroutines.flow.Flow

class MovieRepo {

    fun getNowPlaying(position: Int): Flow<PagingData<MovieData>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(position) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}
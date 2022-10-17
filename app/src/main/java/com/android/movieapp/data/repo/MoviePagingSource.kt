package com.android.movieapp.data.repo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.movieapp.data.model.MovieData
import com.android.movieapp.data.network.ApiManager


private const val STARTING_PAGE_INDEX = 1
private const val NOW_PLAYING = 0
private const val MOST_POPULAR = 1
private const val TOP_RATE = 2
private const val COMING_SOON = 3

class MoviePagingSource(private val tabSelectionPosition : Int) : PagingSource<Int, MovieData>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return  when (tabSelectionPosition) {
            NOW_PLAYING -> ApiManager.getNowPlaying(pageIndex)
            MOST_POPULAR -> ApiManager.getPopularMovie(pageIndex)
            TOP_RATE -> ApiManager.getTopRate(pageIndex)
            COMING_SOON -> ApiManager.getUpComing(pageIndex)
            else -> ApiManager.getNowPlaying(pageIndex)
        }


    }

    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }


}

package com.android.movieapp.data.network

import android.util.Log
import androidx.paging.PagingSource.LoadResult
import com.android.movieapp.data.model.MovieData
import retrofit2.HttpException
import java.io.IOException


object ApiManager {
    private val apiService = ApiServiceBuilder().apiService

    suspend fun getNowPlaying(pageIndex: Int): LoadResult<Int, MovieData> {
        return try {
            Log.d("esther", "NowPlaying : $pageIndex")
            val response = apiService.getNowPlayingMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    }

    suspend fun getPopularMovie(pageIndex: Int): LoadResult<Int, MovieData> {
        return try {
            Log.d("esther", "PopularMovie : $pageIndex")
            val response = apiService.getPopularMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }


    suspend fun getTopRate(pageIndex: Int): LoadResult<Int, MovieData> {
        return try {
            Log.d("esther", "getTopRate : $pageIndex")
            val response = apiService.getTopRatedMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    suspend fun getUpComing(pageIndex: Int): LoadResult<Int, MovieData> {
        return try {
            Log.d("esther", "getUpComing : $pageIndex")
            val response = apiService.getUpcomingMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}
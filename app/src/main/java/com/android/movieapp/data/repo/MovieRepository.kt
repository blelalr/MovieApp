package com.android.movieapp.data.repo

import androidx.paging.PagingSource
import com.android.movieapp.MovieCategory
import com.android.movieapp.data.model.MovieData
import com.android.movieapp.data.network.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class MovieRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovieByCategory(pageIndex: Int, movieCategory :MovieCategory): PagingSource.LoadResult<Int, MovieData> {
        return try {

            val response = when(movieCategory){
                MovieCategory.NOW_PLAYING -> apiService.getNowPlayingMovies(pageIndex)
                MovieCategory.MOST_POPULAR -> apiService.getPopularMovies(pageIndex)
                MovieCategory.TOP_RATE -> apiService.getTopRatedMovies(pageIndex)
                MovieCategory.COMING_SOON -> apiService.getUpcomingMovies(pageIndex)
            }

            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            PagingSource.LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            PagingSource.LoadResult.Error(exception)
        }

    }


    suspend fun getNowPlaying(pageIndex: Int): PagingSource.LoadResult<Int, MovieData> {
        return try {
            val response = apiService.getNowPlayingMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            PagingSource.LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            PagingSource.LoadResult.Error(exception)
        }

    }

    suspend fun getPopularMovie(pageIndex: Int): PagingSource.LoadResult<Int, MovieData> {
        return try {
            val response = apiService.getPopularMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            PagingSource.LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            PagingSource.LoadResult.Error(exception)
        }
    }


    suspend fun getTopRate(pageIndex: Int): PagingSource.LoadResult<Int, MovieData> {
        return try {
            val response = apiService.getTopRatedMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            PagingSource.LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            PagingSource.LoadResult.Error(exception)
        }
    }

    suspend fun getUpComing(pageIndex: Int): PagingSource.LoadResult<Int, MovieData> {
        return try {
            val response = apiService.getUpcomingMovies(page = pageIndex)
            val repos = response.movies
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            PagingSource.LoadResult.Page(
                data = repos,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            PagingSource.LoadResult.Error(exception)
        }
    }

}
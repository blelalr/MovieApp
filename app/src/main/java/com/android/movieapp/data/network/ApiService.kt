package com.android.movieapp.data.network

import com.android.movieapp.data.model.*
import org.intellij.lang.annotations.Language
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

@JvmSuppressWildcards
interface ApiService {

    @GET("/3/authentication/guest_session/new")
    suspend fun getCreateGuestSession(): Response<GuestSessionData>

    @GET("/3/authentication/token/new")
    suspend fun getRequestToken(): Response<RequestTokenData>

    @POST("/3/authentication/token/validate_with_login")
    suspend fun postAuthWithLogin(
        @Body body: SessionWithLoginReqData
    ): Response<RequestTokenData>

    @POST("/3/authentication/session/new")
    suspend fun postCreateSession(
        @Body body: SessionReqData
    ): Response<SessionData>

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = ApiConstant.API_KEY_V3,
        @Query("language") language: String = ApiConstant.LANGUAGE
    ): MoviePageData

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = ApiConstant.API_KEY_V3,
        @Query("language") language: String = ApiConstant.LANGUAGE
    ): MoviePageData

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = ApiConstant.API_KEY_V3,
        @Query("language") language: String = ApiConstant.LANGUAGE
    ): MoviePageData

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = ApiConstant.API_KEY_V3,
        @Query("language") language: String = ApiConstant.LANGUAGE
    ): MoviePageData

}

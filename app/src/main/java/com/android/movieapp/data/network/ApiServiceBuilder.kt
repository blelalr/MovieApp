package com.android.movieapp.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiServiceBuilder {
    private val retrofit: Retrofit
    val apiService: ApiService

    init {

        val authInterceptor = Interceptor {
            val newUrl = it.request().url.newBuilder()
                .addQueryParameter("api_key", ApiConstant.API_KEY_V3)
                .addQueryParameter("language", ApiConstant.LANGUAGE)
                .build()
            val newRequest = it.request().newBuilder().url(newUrl).build()
            it.proceed(newRequest)
        }

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
                .addInterceptor(logging)
                .build()

        retrofit = Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        apiService = retrofit.create(ApiService::class.java)
    }

}
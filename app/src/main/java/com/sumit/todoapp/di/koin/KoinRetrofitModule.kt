package com.sumit.todoapp.di.koin

import com.google.gson.Gson
import com.sumit.todoapp.api.remote.ApiService
import com.sumit.todoapp.util.Constants
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val koinRetrofitModule = module {
    single { GsonConverterFactory.create() }

    single { Gson() }

    single {
        OkHttpClient
            .Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .hostnameVerifier { _, _ -> true }
            .build()
    }

    single {
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
            .create(ApiService::class.java)
    }
}
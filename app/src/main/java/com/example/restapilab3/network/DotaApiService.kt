package com.example.restapilab3.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET



private const val BASE_URL =
    "https://api.opendota.com/api/"


    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()



interface DotaApiService {
    @GET("heroes")
    fun getHeroes():
            Call<List<Hero>>

    @GET("heroStats")
    fun getHeroesStats():
            Call<List<HeroStats>>
}

    object DotaApi {
    val retrofitService : DotaApiService by lazy {
        retrofit.create(DotaApiService::class.java) }
    }
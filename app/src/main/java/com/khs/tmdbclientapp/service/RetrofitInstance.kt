package com.khs.tmdbclientapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {
    companion object{
        private val BASE_URL = "https://api.themoviedb.org/3/"
        private var retrofit:Retrofit?=null
        fun getInstance():MovieAPIService?{
            if(retrofit==null){
                retrofit = Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(MovieAPIService::class.java)
        }
    }
}
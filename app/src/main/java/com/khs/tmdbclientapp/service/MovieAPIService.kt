package com.khs.tmdbclientapp.service

import com.khs.tmdbclientapp.model.MovieDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 *@auther hyeoksin
 *@since
 */
interface MovieAPIService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") api_key:String, @Query("language") language:String):Call<MovieDBResponse>

}
package com.khs.tmdbclientapp.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.khs.tmdbclientapp.R
import com.khs.tmdbclientapp.model.Movie
import com.khs.tmdbclientapp.model.MovieDBResponse
import com.khs.tmdbclientapp.service.MovieAPIService
import com.khs.tmdbclientapp.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 *@auther hyeoksin
 *@since
 */
class MovieRepository(
    private val application: Application
){
    private lateinit var movies:ArrayList<Movie>
    private var service:MovieAPIService
    private var mutableLiveData:MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        service = RetrofitInstance.getInstance()!!
    }

    fun getMutableLiveData():MutableLiveData<List<Movie>>{

        val callBack = service.getPopularMovies(
            application.applicationContext.getString(R.string.api_key),
            application.applicationContext.getString(R.string.language)
        )

        callBack?.enqueue(object : Callback<MovieDBResponse> {
            override fun onFailure(call: Call<MovieDBResponse>, t: Throwable) {}
            override fun onResponse(call: Call<MovieDBResponse>, response: Response<MovieDBResponse>) {
                val movieDBResponse = response.body()
                if(movieDBResponse!=null && movieDBResponse.movies!=null) {
                    movies = movieDBResponse.movies
                    mutableLiveData.value = movies
                }
            }
        })
        return mutableLiveData
    }

}
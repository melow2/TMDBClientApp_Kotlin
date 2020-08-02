package com.khs.tmdbclientapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khs.tmdbclientapp.model.Movie
import com.khs.tmdbclientapp.model.MovieDBResponse
import com.khs.tmdbclientapp.repository.MovieRepository

class MainViewModel :AndroidViewModel{

    private lateinit var movieRepository: MovieRepository

    constructor(application: Application):super(application){
       movieRepository = MovieRepository(application)
    }

    fun getAllMovies():LiveData<List<Movie>>{
        return movieRepository.getMutableLiveData()
    }

}
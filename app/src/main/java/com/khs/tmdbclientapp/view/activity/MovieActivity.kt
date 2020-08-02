package com.khs.tmdbclientapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.khs.tmdbclientapp.R
import com.khs.tmdbclientapp.databinding.MovieActivityBinder
import com.khs.tmdbclientapp.model.Movie

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: MovieActivityBinder
    private lateinit var toolbar:Toolbar
    private lateinit var movie:Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        init()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if(intent.hasExtra("movie")){
            movie = intent.getParcelableExtra("movie")
            binding.movie = movie
            supportActionBar?.title = movie.title
        }
    }
}

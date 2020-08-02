package com.khs.tmdbclientapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.khs.tmdbclientapp.view.activity.MainActivity
import com.khs.tmdbclientapp.R
import com.khs.tmdbclientapp.databinding.MovieBinder
import com.khs.tmdbclientapp.model.Movie
import com.khs.tmdbclientapp.view.adapter.util.MovieDiffUtil
import com.khs.tmdbclientapp.view.holder.MovieViewHolder

/**
 *
 *@auther hyeoksin
 *@since
 */

class MovieAdapter(
    private val context: Context
): ListAdapter<Movie, MovieViewHolder>(MovieDiffUtil()){

    private lateinit var movieBinder: MovieBinder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        movieBinder = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,false)
        movieBinder.handlers = (context as MainActivity).handlers
        return MovieViewHolder(context,movieBinder)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        movieBinder.movie = getItem(holder.adapterPosition)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    } // 위치를 잡아줌
}
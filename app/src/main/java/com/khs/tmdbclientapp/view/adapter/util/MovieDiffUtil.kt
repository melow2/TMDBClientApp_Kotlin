package com.khs.tmdbclientapp.view.adapter.util

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.khs.tmdbclientapp.model.Movie

/**
 *
 *@auther hyeoksin
 *@since
 */

class MovieDiffUtil:DiffUtil.ItemCallback<Movie>(){
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.originalTitle == newItem.originalTitle
    }
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.voteAverage == newItem.voteAverage
    }
}
package com.khs.tmdbclientapp.view.holder

import android.content.Context
import com.khs.tmdbclientapp.databinding.MovieBinder

/**
 *
 *@auther hyeoksin
 *@since
 */
class MovieViewHolder:BaseViewHolder{
    private lateinit var movieBinder: MovieBinder
    constructor(context: Context,movieBinder: MovieBinder):super(context,movieBinder.root){
        this.movieBinder = movieBinder
    }
    override fun bindDataToViewHolder() {}
}
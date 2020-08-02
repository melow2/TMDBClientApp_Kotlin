package com.khs.tmdbclientapp.view

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.khs.tmdbclientapp.view.activity.MainActivity
import com.khs.tmdbclientapp.R


class MovieSwipeLayout(
    private val activity: MainActivity,
    private val layout: SwipeRefreshLayout
):SwipeRefreshLayout.OnRefreshListener{

    init {
        layout.setColorSchemeResources(R.color.colorPrimary)
        layout.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        activity.getPopularMovies()
        layout.isRefreshing = false
    }
}
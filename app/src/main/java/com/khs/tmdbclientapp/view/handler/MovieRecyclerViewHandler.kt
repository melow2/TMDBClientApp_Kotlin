package com.khs.tmdbclientapp.view.handler

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.khs.tmdbclientapp.model.Movie
import com.khs.tmdbclientapp.view.activity.MovieActivity
import com.khs.tmdbclientapp.view.adapter.MovieAdapter

/**
 *
 *@auther hyeoksin
 *@since '
 */
class MovieRecyclerViewHandler(
    val context: Context,
    val adapter: MovieAdapter
):ItemTouchHelper.Callback(){

    fun onItemClicked(view: View,item:Movie){
        var Intent = Intent(context, MovieActivity::class.java)
        Intent?.putExtra("movie",item)
        context.startActivity(Intent)
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        var swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags,swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

}

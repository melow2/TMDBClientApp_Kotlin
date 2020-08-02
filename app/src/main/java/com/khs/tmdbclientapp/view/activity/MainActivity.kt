package com.khs.tmdbclientapp.view.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.khs.tmdbclientapp.R
import com.khs.tmdbclientapp.databinding.MainBinder
import com.khs.tmdbclientapp.model.Movie
import com.khs.tmdbclientapp.model.MovieDBResponse
import com.khs.tmdbclientapp.service.MovieAPIService
import com.khs.tmdbclientapp.service.RetrofitInstance
import com.khs.tmdbclientapp.view.adapter.MovieAdapter
import com.khs.tmdbclientapp.view.MovieSwipeLayout
import com.khs.tmdbclientapp.view.handler.MovieRecyclerViewHandler
import com.khs.tmdbclientapp.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var service:MovieAPIService
    private lateinit var binding:MainBinder
    private lateinit var viewModel:MainViewModel

    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:MovieAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper
    lateinit var handlers:MovieRecyclerViewHandler

    private lateinit var movieSwipeLayout: MovieSwipeLayout

    private lateinit var movies:ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setTitle("TMDB Popular Movies Today")
        init()
        getPopularMovies()
    }

    private fun init() {
        service = RetrofitInstance.getInstance()!!

        // Set Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this

        // Set Recycler View
        recyclerView = binding.rvMovies
        adapter = MovieAdapter(this)
        recyclerView.adapter = adapter
        handlers = MovieRecyclerViewHandler(this,adapter)
        itemTouchHelper = ItemTouchHelper(handlers)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Set SwipeLayout
        movieSwipeLayout = MovieSwipeLayout(this, binding.srlMovies)
    }

    fun getPopularMovies() {
        viewModel.getAllMovies().observe(this,Observer<List<Movie>>{
            setRecyclerView()
            movies = it as ArrayList<Movie>
            adapter.submitList(movies)
        })
    }

    private fun setRecyclerView() {
        if(this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.layoutManager = GridLayoutManager(this,2)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this,4)
        }
    }

}

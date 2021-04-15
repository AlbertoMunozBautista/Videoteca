package com.example.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.videoteca.R
import com.example.videoteca.adapter.MoviesAdapter
import com.example.videoteca.model.Movie
import com.example.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = ":::TAG"

    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MoviesAdapter()

        recyclerview.adapter = adapter

        adapter.refreshList(getListFromJson())
    }

    private fun getListFromJson() : ArrayList<Movie>{
        val json = getJsonFromAssets("movies.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        return ArrayList(movieList)
    }
}
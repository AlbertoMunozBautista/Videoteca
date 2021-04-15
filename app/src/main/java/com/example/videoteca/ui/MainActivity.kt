package com.example.videoteca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.videoteca.R
import com.example.videoteca.model.Movie
import com.example.videoteca.utils.getJsonFromAssets
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val TAG = ":::TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, getListFromJson().toString())
    }

    private fun getListFromJson() : ArrayList<Movie>{
        val json = getJsonFromAssets("movies.json")
        val movieList = Gson().fromJson(json, Array<Movie>::class.java).toList()
        return ArrayList(movieList)
    }
}
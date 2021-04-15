package com.example.videoteca.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videoteca.R
import com.example.videoteca.model.Movie
import com.example.videoteca.utils.inflate

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>(){

    private var movieList = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = parent.inflate(R.layout.item_movie, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    fun refreshList(movieList : ArrayList<Movie>){
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

}
package com.example.videoteca.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videoteca.R
import com.example.videoteca.model.Movie
import com.example.videoteca.utils.inflate
import java.util.*
import kotlin.collections.ArrayList

class MoviesAdapter(private val listener: (Movie) -> Unit) : RecyclerView.Adapter<MoviesViewHolder>(){

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
        holder.itemView.setOnClickListener { listener(movie) }
    }

    fun refreshList(movieList : ArrayList<Movie>){
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

    fun filterByName(movies : List<Movie>){

        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

}
package com.example.practica6.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica6.R
import com.example.practica6.databinding.CardBatmanMoviesItemBinding
import com.example.practica6.server.model.Movie
import com.squareup.picasso.Picasso

class ListAdapter (
    private var moviesList: ArrayList<Movie>,
    private val onItemClick: (Movie) -> Unit
        ): RecyclerView.Adapter<ListAdapter.MoviesViewHolder>(){

            class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
                private val binding= CardBatmanMoviesItemBinding.bind(itemView)

                fun bindMovie(movie: Movie){
                    with(binding){
                        Picasso.get().load(movie.poster).into(imageView)
                        imageView.setOnClickListener(){
                            tittleTextview.text = movie.title
                            yearTextview.text=movie.year
                        }
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_batman_movies_item,parent,false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.bindMovie(movie)
        holder.itemView.setOnClickListener{onItemClick(movie)}
    }

    fun appendItems(newList: ArrayList<Movie>){
        moviesList.clear()
        moviesList.addAll(newList)
        notifyItemInserted(newList.size)
    }
}
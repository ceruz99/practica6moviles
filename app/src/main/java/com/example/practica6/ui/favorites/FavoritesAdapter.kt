package com.example.practica6.ui.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica6.R
import com.example.practica6.databinding.CardBatmanMoviesItemBinding
import com.example.practica6.local.model.LocalMovie
import com.squareup.picasso.Picasso

class FavoritesAdapter (
    private var moviesList: ArrayList<LocalMovie>,
    private val onItemClicked: (LocalMovie) -> Unit,
    private val onItemLongClicked : (LocalMovie) ->Unit,
        ): RecyclerView.Adapter<FavoritesAdapter.MoviesViewHolder>(){

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding= CardBatmanMoviesItemBinding.bind(itemView)

        fun bindMovie(movie: LocalMovie){
            with(binding){
                Picasso.get().load(movie.poster).into(imageView)
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
        holder.itemView.setOnClickListener{onItemClicked(movie)}
        holder.itemView.setOnLongClickListener{onItemLongClicked(movie)
        true}
    }

    fun appendItems(newList: ArrayList<LocalMovie>){
        moviesList.clear()
        moviesList.addAll(newList)
        notifyDataSetChanged()
    }
}
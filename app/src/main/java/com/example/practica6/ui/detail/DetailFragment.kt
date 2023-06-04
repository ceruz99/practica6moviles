package com.example.practica6.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.practica6.R
import com.example.practica6.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {


    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private var isMovieSaved = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root

        val movie = args.movie

        viewModel.searchMovie(movie.imdbID.substring(2,9).toInt())

        viewModel.isMovieSaved.observe(viewLifecycleOwner){isMovieSaved->
            this.isMovieSaved = isMovieSaved
            if(isMovieSaved){
                binding.imageView3.setImageDrawable(resources.getDrawable(R.drawable.baseline_check_24))
            }
            else{
                binding.imageView3.setImageDrawable(resources.getDrawable(R.drawable.baseline_save_24))
            }
        }

        with(binding){
            titleTextView.text= movie.title
            yearTextView.text=movie.year
            Picasso.get().load(movie.poster).into(imageView2)

            imageView3.setOnClickListener{
                if(isMovieSaved)
                    Toast.makeText(context, "${movie.title} is already in favorites.", Toast.LENGTH_LONG).show()
                else{
                    isMovieSaved=true
                    imageView3.setImageDrawable(resources.getDrawable(R.drawable.baseline_save_24))
                    viewModel.saveMovie(movie)
                }
            }
        }

        return view
    }

}
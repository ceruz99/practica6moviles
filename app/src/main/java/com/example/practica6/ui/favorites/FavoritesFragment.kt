package com.example.practica6.ui.favorites

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica6.R
import com.example.practica6.databinding.FragmentFavoritesBinding
import com.example.practica6.local.model.LocalMovie

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private lateinit var favoritesViewModel : FavoritesViewModel
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val favoritesList = ArrayList<LocalMovie>()
        val favoritesAdapter = FavoritesAdapter(favoritesList, onItemClicked = {},
            onItemLongClicked = {localMovie ->
                deleteFavorite(localMovie)
            })

        binding.favoritesRecyclerview.apply{
            layoutManager = LinearLayoutManager(this@FavoritesFragment.requireContext())
            adapter = favoritesAdapter
            setHasFixedSize(false)
        }

        favoritesViewModel.loadFavorites()

        favoritesViewModel.favoritesMovies.observe(viewLifecycleOwner){favoritesList->
            favoritesAdapter.appendItems(favoritesList)
        }

        return root
    }

    private fun deleteFavorite(localMovie: LocalMovie) {
        val alertDialog: AlertDialog? = activity?.let{
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setMessage("Do you want to delete ${localMovie.name}?")
                setPositiveButton(R.string.accept){dialog,id->
                    favoritesViewModel.deleteFavorite(localMovie)
                    favoritesViewModel.loadFavorites()
                }
                setNegativeButton(R.string.cancel){dialog,id->

                }
            }
            builder.create()
        }
        alertDialog?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
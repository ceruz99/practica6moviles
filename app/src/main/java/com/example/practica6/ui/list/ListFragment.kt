package com.example.practica6.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica6.databinding.FragmentListBinding
import com.example.practica6.server.model.Movie

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val moviesList = ArrayList<Movie>()
        val listAdapter = ListAdapter(moviesList, onItemClicked = {movie -> onItemClicked(movie)})

        binding.batmanRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter=listAdapter
            setHasFixedSize(false)
        }

        listViewModel.loadMovies()

        listViewModel.moviesLoaded.observe(viewLifecycleOwner){listMovies->
            listAdapter.appendItems(listMovies as ArrayList<Movie>)
        }

        return root
    }

    private fun onItemClicked(movie: Movie){
        findNavController().navigate(ListFragmentDirections.actionNavigationListToDetailFragment(movie = movie))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
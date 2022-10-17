package com.android.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.movieapp.data.model.MovieData
import com.android.movieapp.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val moviePageAdapter by lazy { MoviePageAdapter { movie: MovieData ->  openMovieDetail(movie) } }



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        lifecycleScope.launch {
            homeViewModel.getMoviesByTabPosition(0).collectLatest {
                moviePageAdapter.submitData(it)
            }
        }

    }

    private fun initView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvMovies.layoutManager = layoutManager
        binding.rvMovies.adapter = moviePageAdapter
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab != null) {
                    lifecycleScope.launch {
                        homeViewModel.getMoviesByTabPosition(tab.position).collectLatest {
                            moviePageAdapter.submitData(it)
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

    }


    private fun openMovieDetail(movie: MovieData) {
//        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {



    }


}
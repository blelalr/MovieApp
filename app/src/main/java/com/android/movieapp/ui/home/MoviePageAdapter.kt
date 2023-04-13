package com.android.movieapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.movieapp.data.model.MovieData
import com.android.movieapp.databinding.ItemPagerMovieBinding
import com.bumptech.glide.Glide

class MoviePageAdapter(private val movieOnClickListener: (MovieData) -> Unit): PagingDataAdapter<MovieData, MovieViewHolder>(MovieDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie, movieOnClickListener)
        }

    }
}


class MovieViewHolder(private val binding: ItemPagerMovieBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieData, movieOnClickListener: (MovieData) -> Unit) {
        binding.root.setOnClickListener {
            movieOnClickListener(movie)
        }
        Glide.with(binding.root.context)
            .load("https://image.tmdb.org/t/p/w500${movie.posterPath}").into(binding.ivMovie)

    }

    companion object {
        fun from(parent: ViewGroup): MovieViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPagerMovieBinding.inflate(layoutInflater, parent, false)
            return MovieViewHolder(binding)
        }

    }
}


class MovieDiffCallback: DiffUtil.ItemCallback<MovieData>() {
    override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
        return oldItem == newItem
    }

}
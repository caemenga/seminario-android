package ar.edu.unicen.aplicacionpeliculas.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unicen.aplicacionpeliculas.databinding.ListMoviesActivityBinding
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie

class MovieAdapter(
    private val movies: List<ActivityMovie>
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val biding = ListMoviesActivityBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(biding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }
    class MovieViewHolder(
        private val biding: ListMoviesActivityBinding
    ): RecyclerView.ViewHolder(biding.root) {
        fun bind(movie: ActivityMovie) {
            biding.movieTitle.text = movie.title
            biding.movieOverview.text = movie.movieInfo.overview

        }


    }
}
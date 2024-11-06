package ar.edu.unicen.aplicacionpeliculas.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ar.edu.unicen.aplicacionpeliculas.databinding.ActivityMovieBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MovieActivity: AppCompatActivity() {
     private lateinit var biding: ActivityMovieBinding

     private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(biding.root)

        val movieId = intent.getIntExtra("MOVIE_ID", -1)

        if (movieId != -1) {
            viewModel.getMovie(movieId)
        } else {
            Log.e("MovieActivity", "Invalid movie ID received")
        }

        viewModel.movie.onEach{ movie ->
            biding.titleMovie.text = movie?.title.orEmpty()
            biding.ratingMovie.text = movie?.movieInfo?.popularity.toString().orEmpty()
            biding.movieDescription.text = movie?.movieInfo?.overview.orEmpty()
            Glide.with(biding.root)
                .load("https://image.tmdb.org/t/p/w500/${movie?.movieInfo?.poster_path}")
                .into(biding.movieImage)
            Log.e("MovieActivity", "Movie received in UI: ${movie?.title}")
        }.launchIn(lifecycleScope)
    }
}
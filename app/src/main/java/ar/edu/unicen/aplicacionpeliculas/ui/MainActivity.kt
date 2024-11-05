package ar.edu.unicen.aplicacionpeliculas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.edu.unicen.aplicacionpeliculas.databinding.ActivityMainBinding
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(biding.root)

//        biding.verMasButton.setOnClickListener {
//            val movieId = 123
//            val intent = Intent(this, MovieActivity::class.java)
//                //.apply {
//                //putExtra("MOVIE_ID", movieId)
//                //}
//                startActivity(intent)
//
//        }
        viewModel.getPopularMovies()
        viewModel.movies.onEach{ movies ->
            biding.moviesList.adapter = MovieAdapter(movies ?: emptyList())
        }.launchIn(lifecycleScope)
    }
}
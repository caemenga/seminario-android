package ar.edu.unicen.aplicacionpeliculas.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unicen.aplicacionpeliculas.ddl.data.MovieRepository
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(

    private val movieRepository: MovieRepository
): ViewModel(){
    private val _movie = MutableStateFlow<ActivityMovie?>(null)
    val movie = _movie.asStateFlow()


    fun getMovie(
        movie_id : Int
    ){
         viewModelScope.launch{
             _movie.value = null
             val movie = movieRepository.getMovie(movie_id)
             Log.e("MovieViewModel", "movie: $movie")
             _movie.value = movie
         }


    }
}
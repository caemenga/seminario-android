package ar.edu.unicen.aplicacionpeliculas.ui


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unicen.aplicacionpeliculas.ddl.data.MovieRepository
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {
    private val _movies = MutableStateFlow<List<ActivityMovie>?>(null)
    val movies = _movies.asStateFlow()

    fun getPopularMovies(){
        viewModelScope.launch{
            _movies.value = null
            val movies = movieRepository.getPopularMovies("en-US", 1)
            Log.e("MovieViewModel", "movie: $movies")
            _movies.value = movies
        }
    }

}
package ar.edu.unicen.aplicacionpeliculas.ddl.data

import android.util.Log
import ar.edu.unicen.aplicacionpeliculas.ddl.MovieLocalDataSource
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie
import ar.edu.unicen.aplicacionpeliculas.ddl.model.MovieImage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
) {

    suspend fun getMovie(
        movie_id: Int
    ): ActivityMovie? {
        val movie = remoteDataSource.getMovie(movie_id)
        //Log.e("MovieRepository", "Movie data: $movie")
        return movie
    }

//    suspend fun getImage(poster_path: String): MovieImage {
//        val image = remoteDataSource.getMovie(poster_path)
//        return image
//    }

    suspend fun getPopularMovies(
        language: String,
        page: Int
    ): List<ActivityMovie>? {
        val movies = remoteDataSource.getPopularMovies(language, page)
        return movies
    }
}
package ar.edu.unicen.aplicacionpeliculas.ddl.data

import android.annotation.SuppressLint
import android.util.Log
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie
import ar.edu.unicen.aplicacionpeliculas.ddl.model.MovieImage
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSource
   @Inject constructor (
    val movieApi:MovieApi
    ) {

    @SuppressLint("SuspiciousIndentation")
    suspend fun getMovie(
        movie_id:Int
    ):ActivityMovie?{
        try{
        val response: Response<ActivityMovieDto> = movieApi.getMovie(movie_id)

        val activityMovie = response.body()?.toMovie()
            Log.d("RemoteDataSource", "API Response: ${response.body().toString()}")

            return activityMovie

        }catch (e: Exception){

            Log.e("RemoteDataSource", "API Error", e)
            return null
        }

    }

//    suspend fun getImage(
//        poster_path: String
//    ): MovieImage {
//            val response: Response<ConfigImageDto> = movieApi.getImage()
//
//    }

    suspend fun getPopularMovies(
        language: String,
         page: Int
    ): List<ActivityMovie>? {
        try {
            Log.e("tryRemote", "language = $language page = ${page.toString()}")
            val response: Response<PopularMoviesDto> = movieApi.getPopularMovies(language, page)
            Log.e("response body", "${response.body().toString()}")
            val movies = response.body()?.toActivityMovieList()
            Log.d("RemoteDataSource", "entro a try rds API Response: ${response.body()?.results}")
            return movies
        } catch (e: Exception) {
            Log.e("RemoteDataSource", "API Error", e)
            return null
        }
    }
}
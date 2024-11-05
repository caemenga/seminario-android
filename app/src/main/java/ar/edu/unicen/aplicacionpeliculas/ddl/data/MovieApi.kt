package ar.edu.unicen.aplicacionpeliculas.ddl.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movie_id: Int = 123,
        @Query("language") language: String = "en-US"
    ):Response<ActivityMovieDto>

    @GET("configuration")
    suspend fun getImage(
    ):Response<ConfigImageDto>

    @GET("popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Response<PopularMoviesDto>

}

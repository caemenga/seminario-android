package ar.edu.unicen.aplicacionpeliculas.ddl.data

import android.util.Log
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovieInfo
import com.google.gson.annotations.SerializedName

class PopularMoviesDto(
    @SerializedName("results")
    val results: List<ActivityMovieDto>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int

) {

    fun toActivityMovieList(): List<ActivityMovie> {
        Log.e("dtoPopular", "entro a toActivityMovieList")
        return results.map { dto ->
            ActivityMovie(
                id = dto.id,
                title = dto.title,
                movieInfo = ActivityMovieInfo(
                    original_title = dto.original_title,
                    original_language = dto.original_language,
                    overview = dto.overview,
                    release_date = dto.release_date,
                    popularity = dto.popularity,
                    vote_count = dto.vote_count,
                    vote_average = dto.vote_average,
                    adult = dto.adult,
                    poster_path = dto.poster_path,
                    backdrop_path = dto.backdrop_path
                )

            )
        }
    }

    override fun toString(): String {
        return "entraste al dto, page = ${page.toString()} total de resultados ${total_results.toString()}"
    }
}


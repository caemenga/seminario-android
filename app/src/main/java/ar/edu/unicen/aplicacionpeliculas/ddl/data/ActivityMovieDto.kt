package ar.edu.unicen.aplicacionpeliculas.ddl.data

import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie
import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovieInfo
import com.google.gson.annotations.SerializedName

class ActivityMovieDto(
   @SerializedName("adult")  
    val adult: Boolean,
   @SerializedName("backdrop_path")
    val backdrop_path: String,
   @SerializedName("genre_ids")
   val genre_ids: List<Int>,
   @SerializedName("id")
    val id: Int,
   @SerializedName("original_language")
    val original_language: String,
   @SerializedName("original_title")
   val original_title: String,
   @SerializedName("overview")
   val overview: String,
   @SerializedName("popularity")
   val popularity: Double,
   @SerializedName("poster_path")
   val poster_path: String,
   @SerializedName("release_date")
   val release_date: String,
   @SerializedName("title")
   val title: String,
   @SerializedName("video")
   val video: Boolean,
   @SerializedName("vote_average")
   val vote_average: Double,
   @SerializedName("vote_count")
   val vote_count: Int
) {

    override fun toString(): String {
        return "ActivityMovieDto(id=$id, title='$title', " +
                "popularity=$popularity, vote_average=$vote_average, " +
                "overview='$overview', release_date='$release_date')"
    }
    fun toMovie(): ActivityMovie{
        return ActivityMovie(
            id=id,
            title = title,
            movieInfo = ActivityMovieInfo(
                original_language = original_language,
                original_title = original_title,
                overview = overview,
                adult= adult,
                popularity = popularity,
                release_date = release_date,
                vote_average = vote_average,
                vote_count = vote_count,
                poster_path = poster_path,
                backdrop_path = backdrop_path
                )
            )
    }
}

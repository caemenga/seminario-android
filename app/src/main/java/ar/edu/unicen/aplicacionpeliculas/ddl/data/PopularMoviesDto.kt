package ar.edu.unicen.aplicacionpeliculas.ddl.data

import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityMovie
import com.google.gson.annotations.SerializedName

class PopularMoviesDto(
    @SerializedName("results")
    val results: List<ActivityMovieDto>
) {

//    fun getList(){
//        val results: List<ActivityMovie>
//        for (dto: popularMovie)
//    }

}
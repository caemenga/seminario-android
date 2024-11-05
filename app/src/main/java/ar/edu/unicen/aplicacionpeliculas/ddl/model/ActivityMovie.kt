package ar.edu.unicen.aplicacionpeliculas.ddl.model

class ActivityMovie(
    val id: Int,
    val title: String,
    val movieInfo: ActivityMovieInfo
) {

    override fun toString(): String {
        return "Movie : title: $title, id: $id"
    }
}
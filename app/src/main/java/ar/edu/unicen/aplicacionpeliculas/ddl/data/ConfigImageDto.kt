package ar.edu.unicen.aplicacionpeliculas.ddl.data
import com.google.gson.annotations.SerializedName

//import ar.edu.unicen.aplicacionpeliculas.ddl.model.ActivityConfigImage

class ConfigImageDto(
    @SerializedName("base_url")
    val base_url: String,
    @SerializedName("secure_base_url")
    val secure_base_url: String,
    @SerializedName("backdrop_sizes")
    val backdrop_sizes: List<String>,
    @SerializedName("logo_sizes")
    val logo_sizes: List<String>,
    @SerializedName("poster_sizes")
    val poster_sizes: List<String>,
    @SerializedName("profile_sizes")
    val profile_sizes: List<String>,
    @SerializedName("still_sizes")
    val still_sizes: List<String>,
    @SerializedName("change_keys")
    val change_keys: List<String>
){
    override fun toString(): String {
        return "ConfinImageDto: base_url: $base_url"
    }

//    fun getConfigImage():ActivityConfigImage{
//        return ActivityConfigImage(base_url, poster_sizes.get(4))
//    }
}

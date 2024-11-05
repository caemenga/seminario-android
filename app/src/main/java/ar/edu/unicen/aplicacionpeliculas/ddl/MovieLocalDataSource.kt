package ar.edu.unicen.aplicacionpeliculas.ddl

import android.content.SharedPreferences
import ar.edu.unicen.aplicacionpeliculas.di.MovieSharedPreference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieLocalDataSource @Inject constructor(
    @MovieSharedPreference
    private val sharedPreferences: SharedPreferences
) {

}
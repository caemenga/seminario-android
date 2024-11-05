package ar.edu.unicen.aplicacionpeliculas.di

import android.content.Context
import android.content.SharedPreferences
import ar.edu.unicen.aplicacionpeliculas.ddl.data.AuthInterceptor
import ar.edu.unicen.aplicacionpeliculas.ddl.data.MovieApi
import ar.edu.unicen.aplicacionpeliculas.ddl.data.MovieRemoteDataSource
import ar.edu.unicen.aplicacionpeliculas.ddl.data.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Podes usar tambien el tiempo de vida del ViewModel
class MovieModule {
    private val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmOTg4ZDg4NjUxM2JhYmFhYjljMzgzNTAwNzJhMzA0MCIsIm5iZiI6MTczMDE0OTkzMS4zNjc5MjcsInN1YiI6IjY3MGU5MDMwZDVmOTNhM2RhMGJjNWRlYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VHzQJPV7HX-fLbs6vF-cAs_Y1LkrS6dpWeBecppaoxY"

    @Provides
    @MovieSharedPreference
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext
        context: Context
    ):SharedPreferences{
        return context.getSharedPreferences("movie", Context.MODE_PRIVATE)
    }


    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit{

        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(token))
            .build()


        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi{
        return retrofit.create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(movieApi: MovieApi): MovieRemoteDataSource {
        return MovieRemoteDataSource(movieApi)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: MovieRemoteDataSource): MovieRepository {
        return MovieRepository(remoteDataSource)
    }







}
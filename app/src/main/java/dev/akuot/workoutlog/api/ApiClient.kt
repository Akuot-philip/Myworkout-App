package dev.akuot.mypost

import com.chuckerteam.chucker.api.ChuckerInterceptor
import dev.akuot.workoutlog.WorkoutLog
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    val client = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(WorkoutLog.appContext))
        .build()

    var retrofit = Retrofit.Builder()
        .baseUrl("http://192.81.215.35")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildApiClient(apiIterface:Class<T>):T{
        return retrofit.create(apiIterface)
    }

}
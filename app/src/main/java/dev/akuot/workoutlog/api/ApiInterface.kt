package dev.akuot.workoutlog.api

import dev.akuot.workoutlog.models.LoginRequest
import dev.akuot.workoutlog.models.LoginResponse
import dev.akuot.workoutlog.models.RegisterRequest
import dev.akuot.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest ):Response<RegisterResponse>

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
}



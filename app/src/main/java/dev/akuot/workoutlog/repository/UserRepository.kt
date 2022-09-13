package dev.akuot.workoutlog.repository

import dev.akuot.mypost.APIClient
import dev.akuot.workoutlog.api.ApiInterface
import dev.akuot.workoutlog.models.LoginRequest
import dev.akuot.workoutlog.models.RegisterRequest
import dev.akuot.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = APIClient.buildApiClient((ApiInterface::class.java))

    suspend fun login(loginRequest: LoginRequest) = withContext(Dispatchers.IO){
        val response =apiClient.login(loginRequest)
        return@withContext response
    }

    suspend fun registerUser(registerRequest: RegisterRequest):Response <RegisterResponse> = withContext(Dispatchers.IO){
        val response =apiClient.registerUser(registerRequest)
        return@withContext response
    }
}
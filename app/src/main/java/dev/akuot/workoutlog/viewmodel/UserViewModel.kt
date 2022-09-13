package dev.akuot.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.akuot.workoutlog.models.LoginRequest
import dev.akuot.workoutlog.models.LoginResponse
import dev.akuot.workoutlog.models.RegisterRequest
import dev.akuot.workoutlog.models.RegisterResponse
import dev.akuot.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val UserRepository =UserRepository()
    var loginResponseLiveData =MutableLiveData<LoginResponse>()
    val loginErrorLiveData =MutableLiveData<String?>()

    var registerResponseLiveData =MutableLiveData<RegisterResponse>()
    val registerErrorLiveData =MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = UserRepository.login(loginRequest)
            if(response.isSuccessful){
                loginResponseLiveData.postValue((response.body()))
            }
            else{
                val error =response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
                var registerResponseLiveData =MutableLiveData <RegisterResponse>()
                val registerErrorLiveData =MutableLiveData<String?>()
            }
        }
    }
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = UserRepository.registerUser(registerRequest)
            if(response.isSuccessful){
                registerResponseLiveData.postValue(response.body())
            }
}}}
package dev.akuot.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dev.akuot.mypost.APIClient
import dev.akuot.workoutlog.databinding.ActivityLoginBinding
import dev.akuot.workoutlog.models.LoginRequest
import dev.akuot.workoutlog.models.LoginResponse
import dev.akuot.workoutlog.api.ApiInterface
import dev.akuot.workoutlog.util.Constants
import dev.akuot.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs= getSharedPreferences(Constants.prefsFile, MODE_PRIVATE)

       binding.tvSignup.setOnClickListener{
    val intent=Intent(this, signupActivity::class.java)
    startActivity(intent)
}

        binding.btnLogin.setOnClickListener{
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            validateLogin()
//            finish()

        }
    }
    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { LoginResponse ->
            saveLoginDetails(LoginResponse!!)
            Toast.makeText(baseContext, LoginResponse?.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, HomeActivity::class.java))
            finish()
        })


        userViewModel.loginErrorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })

        }



     fun validateLogin(){
      val email=binding.etEmail.text.toString()
        val password=binding.etPassword.text.toString()
        var error=false

        if (email.isBlank()){
            binding.tilEmail.error ="email required"
            error =true

        }
        if (password.isBlank()){
            binding.tilPassword.error ="Email is required"
            error=true
        }

        if(!error){
            var loginRequest = LoginRequest(email,password)
//            binding.pbLogin.visibility = View.VISIBLE
            userViewModel.loginUser(loginRequest)
//            makeLoginRequest(loginRequest)

        }

        }

    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor = sharedPrefs.edit()
        val token ="Bearer${loginResponse.accessToken}"

        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("PROFILE_ID", loginResponse.profileId)
        editor.apply()
    }

        }


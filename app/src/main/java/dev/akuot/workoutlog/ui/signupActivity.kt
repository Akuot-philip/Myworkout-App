package dev.akuot.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import dev.akuot.mypost.APIClient
import dev.akuot.workoutlog.databinding.ActivitySignupBinding
import dev.akuot.workoutlog.models.RegisterRequest
import dev.akuot.workoutlog.models.RegisterResponse
import dev.akuot.workoutlog.api.ApiInterface
import dev.akuot.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class signupActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignupBinding
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvlogin.setOnClickListener{
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener{

            validateSignup()
        }
    }
     fun validateSignup(){
        var firstName=binding.etFirstname.text.toString()
        var lastName=binding.etLastname.text.toString()
         var email=binding.etEmail.text.toString()
         var password=binding.etPassword.text.toString()
         var Confirm=binding.etConfirmPassword.text.toString()
         var phonenumber=binding.etConfirmPassword.text.toString()
         var error=false

//         var Phonenumber=binding.etPhonenumber.text.toString()

        if (firstName.isBlank()){
            binding.tilFirstName.error="first name required"
        }
         if (lastName.isBlank()){
            binding. tilLastName.error="last name required"
         }
         if (email.isBlank()){
             binding.tilEmail.error="Email required"
         }
         if (password.isBlank()){
             binding.tilPassword.error="Password required"
         }
         if (Confirm.isBlank()){
            binding. tilConfirmPassword.error="Confirm Password"
         }
         if (phonenumber.isBlank()){
             binding. tilphoneNumber.error="put phonenumber"
         }
           if (!error){
               var registerRequest=RegisterRequest(firstName,lastName,password,phonenumber,email)
               userViewModel.registerUser(registerRequest)
//               makeRegistrationRequest(registerRequest)
         }
     }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer {
            signupResponse->
            Toast.makeText(baseContext,signupResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LoginActivity::class.java))
        })
        userViewModel.registerErrorLiveData.observe(this, Observer {
            signupError->
            Toast.makeText(baseContext,signupError,Toast.LENGTH_LONG).show()

        })
    }
}
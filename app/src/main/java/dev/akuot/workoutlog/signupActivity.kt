package dev.akuot.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.akuot.workoutlog.databinding.ActivitySignupBinding

class signupActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignupBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvlogin.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener{
            validateLogin()
        }
    }
     fun validateLogin(){
        var firstName=binding.etFirstname.text.toString()
        var lastName=binding.etLastname.text.toString()
         var email=binding.etEmail.text.toString()
         var password=binding.etPassword.text.toString()
         var Confirm=binding.etConfirmPassword.text.toString()

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
    }
}
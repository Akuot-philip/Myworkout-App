package dev.akuot.workoutlog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.akuot.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnLogin.setOnClickListener{
            validateLogin()
        }
    }


    private fun validateLogin(){
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
        if (!error){
            startActivity(Intent(this,HomeActivity::class.java))


      }

        }

        }


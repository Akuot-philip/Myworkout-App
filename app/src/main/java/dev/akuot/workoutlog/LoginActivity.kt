package dev.akuot.workoutlog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var btnLogin:Button
    private lateinit var tilEmail:TextInputLayout
    private lateinit var tilPassword:TextInputLayout
    private lateinit var etEmail:TextInputEditText
    private lateinit var etPassword:TextInputEditText
    private lateinit var tvSignup:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        btnLogin=findViewById(R.id.btnLogin)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        tvSignup=findViewById(R.id.tvSignup)

        tvSignup.setOnClickListener{
            val intent=Intent(this,signupActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            validateLogin()


        }

    }
    private fun validateLogin(){
      val email=etEmail.text.toString()
        val password=etPassword.text.toString()
        var error=false

        if (email.isBlank()){
            tilEmail.error =getString(R.string.email_required)
            error =true

        }
        if (password.isBlank()){
            tilPassword.error ="Email is required"
            error=true
        }
        if (error){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
    }
}
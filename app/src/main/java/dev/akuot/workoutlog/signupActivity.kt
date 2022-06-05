package dev.akuot.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class signupActivity : AppCompatActivity() {
    lateinit var tilFirstName:TextInputLayout
    lateinit var tilLastName:TextInputLayout
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirmPassword:TextInputLayout

    lateinit var etFirstname:TextInputEditText
    lateinit var etLastname:TextInputEditText
    lateinit var etEmail:TextInputEditText
    lateinit var etPassword:TextInputEditText
    lateinit var etConfirmPassword:TextInputEditText

    lateinit var btnSignup:Button
    lateinit var tvLogin:TextView
    lateinit var tvlogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        tilFirstName=findViewById(R.id.tilFirstName)
        tilLastName=findViewById(R.id.tilLastName)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        tilConfirmPassword=findViewById(R.id.tilConfirmPassword)

        etFirstname=findViewById(R.id.etFirstname)
        etLastname=findViewById(R.id.etLastname)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)

        btnSignup=findViewById(R.id.btnSignup)
        tvLogin=findViewById(R.id.tvLogin)
        tvlogin=findViewById(R.id.tvlogin)


        tvlogin.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignup.setOnClickListener{
            validateLogin()
        }
    }
     fun validateLogin(){
        var firstName=etFirstname.text.toString()
        var lastName=etLastname.text.toString()
         var email=etEmail.text.toString()
         var password=etPassword.text.toString()
         var Confirm=etConfirmPassword.text.toString()

        if (firstName.isBlank()){
            tilFirstName.error="first name required"
        }
         if (lastName.isBlank()){
             tilLastName.error="last name required"
         }
         if (email.isBlank()){
             tilEmail.error="Email required"
         }
         if (password.isBlank()){
             tilPassword.error="Password required"
         }
         if (Confirm.isBlank()){
             tilConfirmPassword.error="Confirm Password"
         }
    }
}
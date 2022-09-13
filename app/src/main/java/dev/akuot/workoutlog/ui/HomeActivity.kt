package dev.akuot.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.akuot.workoutlog.R
import dev.akuot.workoutlog.databinding.ActivityHomeBinding
import dev.akuot.workoutlog.models.LoginResponse

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvLogout.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
            logoutRequest()
        }
        castView()
        setupBottonNav()


    }
    fun castView(){
        binding.fragmentContainerView
        binding.bnvHome
    }
    fun setupBottonNav(){
        binding.bnvHome.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan ->{
                    val  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, ProfileFragment2())
                    transaction.commit()
                    true
                }
                R.id.track ->{
                    val  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, TrackFragment2())
                    transaction.commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, ProfileFragment2()).commit()
                    true
                }
                else -> false

            }
        }

    }
    fun logoutRequest(){
        sharedPrefs.edit().clear().commit()
    }
}








package dev.akuot.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dev.akuot.workoutlog.R
import dev.akuot.workoutlog.databinding.ActivityHomeBinding
import dev.akuot.workoutlog.models.LoginResponse
import dev.akuot.workoutlog.viewmodel.ExerciseViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs:SharedPreferences
    val exerciseViewModel:ExerciseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        sharedPrefs = getSharedPreferences("WORKOUTLOG")


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








package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.result.contract.ActivityResultContracts

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
val handler =Handler(Looper.getMainLooper())
handler.postDelayed({

    val intent = Intent( this,MainActivity::class.java)
  startActivity(intent)
    finish()
},  3000)
    }
}
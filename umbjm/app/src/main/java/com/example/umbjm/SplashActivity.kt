package com.example.umbjm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //menyembunyikan Action Bar
        supportActionBar?.hide()

        Handler().postDelayed({
            //menjalankan MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            //Menghentikan SplashActivity
            finish()
        },3000)
    }
}
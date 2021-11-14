package com.example.valorantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_activity)

        // Declare the Animation
        val ltc = AnimationUtils.loadAnimation(this, R.anim.ltc)
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb)

        val logo = findViewById<ImageView>(R.id.ic_logo)
        val text = findViewById<ImageView>(R.id.ic_text_logo)

        //Set the Animation
        logo.startAnimation(ltc)
        text.startAnimation(stb)

        // Delay for the Splashscreen
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity,
                MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}
package com.example.valorantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        Glide.with(this)
            .load(R.drawable.fay_pic)
            .circleCrop()
            .into(iv_user)

        tvUsername.text = "Faikar Azman Rasyid"
    }
}
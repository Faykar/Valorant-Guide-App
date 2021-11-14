package com.example.valorantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val agent = intent.getParcelableExtra<Agent>("agent")

        btn_back.setOnClickListener {
            finish()
        }

        agent_name.text = agent?.name
        agent_roles.text = agent?.roles
        agent_bio.text = agent?.bio

        agent_skillQ.text = agent?.Q
        agent_descQ.text = agent?.QDescription

        agent_skillE.text = agent?.E
        agent_descE.text = agent?.EDescription

        agent_skillC.text = agent?.C
        agent_descC.text = agent?.CDescription

        agent_skillX.text = agent?.X
        agent_descX.text = agent?.XDescription

        Glide.with(this)
            .load(agent!!.images)
            .into(iv_agent)



    }
}
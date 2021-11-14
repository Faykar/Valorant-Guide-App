package com.example.valorantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAgent: RecyclerView
    private val list = ArrayList<Agent>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setCustomView(R.layout.custom_action_bar)
        supportActionBar!!.customView

        rvAgent = findViewById(R.id.rvAgent)
        rvAgent.setHasFixedSize(true)

        list.addAll(AgentsData.listData)
        showRecyclerCardView()
    }

    private fun showRecyclerCardView(){
        rvAgent.layoutManager = LinearLayoutManager(this)
        val cardViewAgentAdapter = CardViewAgentAdapter(list){
            val intent = Intent(this@MainActivity,
            DetailsActivity::class.java)
                .putExtra("agent", it)
            startActivity(intent)
        }
        rvAgent.adapter = cardViewAgentAdapter

    }

    override fun onOptionsItemSelected(item: MenuItem) :Boolean{
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setMode(selectedMode:Int) {
        when(selectedMode){
            R.id.main -> {
                Toast.makeText(this, "Anda sudah di Main Menu", Toast.LENGTH_SHORT).show()
            }
            R.id.about -> {
                val intent = Intent(this@MainActivity,
                AboutActivity::class.java)
                startActivity(intent)

            }
        }
    }

}
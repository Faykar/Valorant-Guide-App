package com.example.valorantapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewAgentAdapter internal constructor(private val listAgent: ArrayList<Agent>,
                                                private val listener: (Agent) -> Unit
    )
    : RecyclerView.Adapter<CardViewAgentAdapter.CardViewHolder>() {

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewAgentAdapter.CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.item_cardview_agent, parent, false)
        return CardViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: CardViewAgentAdapter.CardViewHolder, position: Int) {
        holder.bindItem(listAgent[position],listener,  contextAdapter)
    }

    override fun getItemCount(): Int {
        return listAgent.size
    }

    inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRoles: TextView = itemView.findViewById(R.id.tv_item_roles)
        var btnDetails: Button = itemView.findViewById(R.id.btn_details)

        fun bindItem(data: Agent, listener: (Agent) -> Unit, context: Context){

            Glide.with(context)
                .load(data.images)
                .into(imgPhoto)

            tvName.text = data.name
            tvRoles.text = data.roles
            btnDetails.setOnClickListener {
                listener(data)
            }


        }

    }
}
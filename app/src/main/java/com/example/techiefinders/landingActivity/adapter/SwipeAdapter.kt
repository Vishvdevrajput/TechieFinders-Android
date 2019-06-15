package com.example.techiefinders.landingActivity.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.techiefinders.R
import com.example.techiefinders.entities.AppliedData
import kotlinx.android.synthetic.main.swipe_item.view.*

class SwipeAdapter(val jobProfileList: ArrayList<AppliedData>, val context: Context, val isApplied: Boolean) :
    RecyclerView.Adapter<SwipeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.swipe_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jobProfileList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobProfile: AppliedData = jobProfileList[position]
        holder.name.setText(jobProfile.name)
        holder.phone.setText("   ${jobProfile.skill[0].tag}   ")
        Glide.with(context).load(jobProfile.imageUrl).into(holder.thumbnail);
        if(isApplied) {
            holder.collaborate.visibility = View.VISIBLE
            holder.collaborate.setOnClickListener {

            }
        } else {
            holder.collaborate.visibility = View.GONE
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.name
        val collaborate: Button = view.collaborate
        val thumbnail: ImageView  = view.thumbnail
        val phone: TextView = view.phone



    }
}
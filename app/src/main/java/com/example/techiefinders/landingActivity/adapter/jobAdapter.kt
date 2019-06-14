package com.example.techiefinders.landingActivity.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.techiefinders.R
import com.example.techiefinders.landingActivity.model.jobProfilemodel
import kotlinx.android.synthetic.main.list_job_description.view.*

class jobAdapter(val jobProfileList: ArrayList<jobProfilemodel>, val context: Context) :
    RecyclerView.Adapter<jobAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_job_description, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jobProfileList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobProfile: jobProfilemodel = jobProfileList[position]
        holder.name.text = jobProfile.name
        holder.skill.text = jobProfile.skill


    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.tv_name
        val skill: TextView = view.tv_skill



    }
}
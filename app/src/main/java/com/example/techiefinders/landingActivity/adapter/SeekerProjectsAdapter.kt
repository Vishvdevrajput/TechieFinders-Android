package com.example.techiefinders.landingActivity.adapter

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.techiefinders.R
import com.example.techiefinders.entities.JobsModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.job_provider_project_list.view.*

class SeekerProjectsAdapter(val jobProfileList: ArrayList<JobsModel>, val context: Context) :
    RecyclerView.Adapter<SeekerProjectsAdapter.ViewHolder>() {

    lateinit var appliedAdapter: SwipeAdapter
    lateinit var suggestedAdapter: SwipeAdapter

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.job_provider_project_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jobProfileList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobProfile: JobsModel = jobProfileList[position]
        holder.job_name.text = jobProfile.jobName
        holder.job_description.text = jobProfile.jobDes
        if (jobProfile.appliedList.size > 0) {
            holder.job_applied_text.visibility = View.VISIBLE
            holder.job_applied_text.text = "${jobProfile.appliedList.size} Applied"
        } else {
            holder.job_applied_text.visibility = View.GONE
        }
        if (jobProfile.suggestedList.size > 0) {
            holder.jobs_suggested_data.visibility = View.VISIBLE
            holder.jobs_suggested_data.text = "${jobProfile.suggestedList.size} Suggested"
        } else {
            holder.jobs_suggested_data.visibility = View.GONE
        }
        suggestedAdapter = SwipeAdapter(jobProfile.suggestedList, context, true)
        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.job_suggested_recyclerView.layoutManager = linearLayoutManager
        holder.job_suggested_recyclerView.adapter = suggestedAdapter
        appliedAdapter = SwipeAdapter(jobProfile.appliedList, context, false)
        var linearManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.job_applied.layoutManager = linearManager
        holder.job_applied.adapter = appliedAdapter

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var job_name: TextView = view.job_name
        var job_description: TextView = view.job_description
        var job_applied_text: TextView = view.job_applied_text
        var jobs_suggested_data: TextView = view.jobs_suggested_data
        var job_suggested_recyclerView: RecyclerView = view.job_suggested_recyclerView
        var job_applied: RecyclerView = view.job_applied
    }
}
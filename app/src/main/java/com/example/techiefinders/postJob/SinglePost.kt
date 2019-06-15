package com.example.techiefinders.postJob

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.techiefinders.R
import com.example.techiefinders.commons.Utils
import com.example.techiefinders.entities.JobsModel
import com.example.techiefinders.entities.JobsResponse
import com.example.techiefinders.landingActivity.adapter.SeekerProjectsAdapter
import com.example.techiefinders.landingActivity.adapter.SwipeAdapter
import com.example.techiefinders.landingActivity.ui.activity.MainActivity
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_single_post.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_single_post.*

class SinglePost : AppCompatActivity() {

    lateinit var suggestedAdapter: SwipeAdapter
    private var jobsList: ArrayList<JobsModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_post)
        var gson = Gson()
        var response: JobsResponse =
            gson.fromJson(Utils().loadJSONFromAsset(this@SinglePost, "singlepost.json"), JobsResponse::class.java)
        jobsList = response.jobs
        singleJobName.text = response.jobs[0].jobName
        single_job_description.text = response.jobs[0].jobDes
        single_jobs_suggested_data.text = "${response.jobs[0].suggestedList.size} suggested"
        initRecyclerView()
        gotoHome.setOnClickListener {
            var intent: Intent = Intent(this@SinglePost, MainActivity::class.java)
            intent.putExtra("isFirstTime", false)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        suggestedAdapter = SwipeAdapter(jobsList[0].suggestedList, this, true)
        var linearLayoutManager = GridLayoutManager(this, 2)
        people_suggested.layoutManager = linearLayoutManager
        people_suggested.adapter = suggestedAdapter
    }

}

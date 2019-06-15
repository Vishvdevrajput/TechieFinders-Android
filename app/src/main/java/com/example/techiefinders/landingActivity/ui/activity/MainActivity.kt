package com.example.techiefinders.landingActivity.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.techiefinders.R
import com.example.techiefinders.commons.Utils
import com.example.techiefinders.entities.JobsModel
import com.example.techiefinders.entities.JobsResponse
import com.example.techiefinders.landingActivity.adapter.SeekerProjectsAdapter
import com.example.techiefinders.landingActivity.adapter.jobAdapter
import com.example.techiefinders.landingActivity.model.jobProfilemodel
import com.example.techiefinders.postJob.PostJob
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SeekerProjectsAdapter
    private var isPosted : Boolean = false
    private var jobsList : ArrayList<JobsModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        submit_discharge_data.setOnClickListener{
            startActivity(Intent(this@MainActivity, PostJob::class.java))
            finish()
        }

    }

    private fun init() {
        initGetArgs()
        if(!isPosted) {
            jobs_posted.visibility = View.VISIBLE
            no_projects.visibility = View.GONE
            var gson = Gson()
            var response: JobsResponse = gson?.fromJson(Utils().loadJSONFromAsset(this@MainActivity, "jobs.json"), JobsResponse::class.java)
            jobsList = response.jobs
            initRecyclerView()
        } else {
            jobs_posted.visibility = View.GONE
            no_projects.visibility = View.VISIBLE
        }

    }

    private fun initGetArgs() {
        if(intent.hasExtra("isFirstTime")) {
            isPosted = intent.getBooleanExtra("isFirstTime", false)
        }
    }

    private fun initRecyclerView() {
        adapter= SeekerProjectsAdapter(jobsList,this)
        var linearLayoutManager = GridLayoutManager(this, 1)
        jobs_posted.layoutManager = linearLayoutManager
        jobs_posted.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

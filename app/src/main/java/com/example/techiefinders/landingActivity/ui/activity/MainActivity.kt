package com.example.techiefinders.landingActivity.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.techiefinders.R
import com.example.techiefinders.landingActivity.adapter.jobAdapter
import com.example.techiefinders.landingActivity.model.jobProfilemodel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: jobAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
        init()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun init() {
        initRecyclerView()
    }

    private fun initRecyclerView() {

        var jobProfileList = ArrayList<jobProfilemodel>()
        val adapter= jobAdapter(jobProfileList,this)
        var linearLayoutManager = GridLayoutManager(this, 2)
        job_description_recyclerview.layoutManager = linearLayoutManager
        job_description_recyclerview.setHasFixedSize(true)


        jobProfileList.add(jobProfilemodel("Serah","java"))
        jobProfileList.add(jobProfilemodel("John","python"))
        jobProfileList.add(jobProfilemodel("Isabel","react"))
        jobProfileList.add(jobProfilemodel("Isabel","react"))

        jobProfileList.add(jobProfilemodel("Isabel","java"))

        jobProfileList.add(jobProfilemodel("Isabel","kotlin"))
        jobProfileList.add(jobProfilemodel("Isabel","react"))
        jobProfileList.add(jobProfilemodel("Isabel","java"))




        job_description_recyclerview.adapter = adapter
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

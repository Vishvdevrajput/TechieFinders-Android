package com.example.techiefinders.postJob

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.techiefinders.R
import com.example.techiefinders.entities.SkillItem
import com.example.techiefinders.iam.register.SkillItemAdapter
import com.example.techiefinders.landingActivity.ui.activity.MainActivity

import kotlinx.android.synthetic.main.activity_post_job.*
import kotlinx.android.synthetic.main.content_post_job.*
import kotlinx.android.synthetic.main.content_single_post.*

class PostJob : AppCompatActivity() {

    private lateinit var adapter: SkillItemAdapter
    private var skillData: ArrayList<SkillItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_job)
        adapter = SkillItemAdapter(skillData, this@PostJob, mInterface)
        experiance_add_post.adapter = adapter
        var linearLayoutManager = LinearLayoutManager(this)
        experiance_add_post.layoutManager = linearLayoutManager
        skillData.add(SkillItem("", ""))
        adapter.notifyDataSetChanged()
        btn_create_job.setOnClickListener {
            var intent: Intent = Intent(this@PostJob, SinglePost::class.java)
            startActivity(intent)
        }
    }


    private val mInterface = object : SkillItemAdapter.SkillInterface {
        override fun onSkillChanged(skill: String, exp: String, position: Int) {
            skillData[position].skill = skill
            skillData[position].exp = exp
            skillData.add(SkillItem("", ""))
            adapter.notifyDataSetChanged()
        }
    }

}

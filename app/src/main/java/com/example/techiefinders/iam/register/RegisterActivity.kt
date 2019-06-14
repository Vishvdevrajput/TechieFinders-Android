package com.example.techiefinders.iam.register

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.techiefinders.R
import com.example.techiefinders.landingActivity.adapter.jobAdapter

import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.content_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var adapter: SkillItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        adapter = SkillItemAdapter()

        skill_recycler_view
    }

}

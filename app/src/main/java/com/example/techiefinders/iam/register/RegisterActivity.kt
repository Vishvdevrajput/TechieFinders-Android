package com.example.techiefinders.iam.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.techiefinders.R
import com.example.techiefinders.entities.SkillItem
import kotlinx.android.synthetic.main.content_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var adapter: SkillItemAdapter
    private var skillData: ArrayList<SkillItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        adapter = SkillItemAdapter(skillData, this@RegisterActivity)
        skill_recycler_view.adapter = adapter
        var linearLayoutManager = GridLayoutManager(this, 1)
        skill_recycler_view.layoutManager = linearLayoutManager
        skillData.add(SkillItem("", ""))
        adapter.notifyDataSetChanged()
    }

}

package com.example.techiefinders.iam.register

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.techiefinders.R
import com.example.techiefinders.entities.SkillItem
import com.example.techiefinders.iam.login.LoginActivity
import com.example.techiefinders.landingActivity.ui.activity.MainActivity
import kotlinx.android.synthetic.main.content_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var adapter: SkillItemAdapter
    private var skillData: ArrayList<SkillItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        adapter = SkillItemAdapter(skillData, this@RegisterActivity, mInterface)
        skill_recycler_view.adapter = adapter
        var linearLayoutManager = GridLayoutManager(this, 1)
        skill_recycler_view.layoutManager = linearLayoutManager
        skillData.add(SkillItem("", ""))
        adapter.notifyDataSetChanged()

        link_login.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

        btn_signup.setOnClickListener {
            var intent: Intent = Intent(this@RegisterActivity, MainActivity::class.java)
            intent.putExtra("isFirstTime", true)
            startActivity(intent)
        }

    }

    private val mInterface = object : SkillItemAdapter.SkillInterface {
        override fun onSkillChanged(skill: String, exp: String, position: Int) {
            skillData[position].skill = skill
            skillData[position].exp =exp
            skillData.add(SkillItem("", ""))
            adapter.notifyDataSetChanged()
        }
    }

}

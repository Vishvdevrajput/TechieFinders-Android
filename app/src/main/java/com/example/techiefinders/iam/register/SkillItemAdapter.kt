package com.example.techiefinders.iam.register

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RelativeLayout
import com.example.techiefinders.R
import com.example.techiefinders.entities.SkillItem
import kotlinx.android.synthetic.main.skill_item.view.*

class SkillItemAdapter(val skillData: ArrayList<SkillItem>, val context: Context) :
    RecyclerView.Adapter<SkillItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.skill_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return skillData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skillData : SkillItem  = skillData[position]
        holder.name.setText("${skillData.skill}")
        holder.experiance.setText("${skillData.exp}")
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: EditText = view.skill_name
        val experiance: EditText = view.skill_experiance
        val add: RelativeLayout = view.add_new

    }
}
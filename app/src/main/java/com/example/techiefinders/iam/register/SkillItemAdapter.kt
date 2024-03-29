package com.example.techiefinders.iam.register

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.techiefinders.R
import com.example.techiefinders.entities.SkillItem
import kotlinx.android.synthetic.main.skill_item.view.*

class SkillItemAdapter(var skillsData: ArrayList<SkillItem>, val context: Context, val mInterface: SkillInterface) :
    RecyclerView.Adapter<SkillItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.skill_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return skillsData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skillData : SkillItem  = skillsData[position]
        holder.name.setText("${skillData.skill}")
        holder.experiance.setText("${skillData.exp}")
        if(position+1 == itemCount) {
            holder.image.background = context.resources.getDrawable(R.drawable.ic_add)
            holder.add.setOnClickListener {
                mInterface.onSkillChanged(holder.name.text.toString(), holder.experiance.text.toString(), position)
            }
        } else {
            holder.image.background = context.resources.getDrawable(R.drawable.ic_delete)
            holder.add.setOnClickListener {
                skillsData.removeAt(position)
                notifyDataSetChanged()
            }
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: EditText = view.skill_name
        val experiance: EditText = view.skill_experiance
        val add: RelativeLayout = view.add_new
        val image: ImageView = view.image_add_sub
    }

    interface SkillInterface {
        fun onSkillChanged(skill: String,exp: String, position: Int)
    }
}
package com.pboox.recyclerviewapp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val tvTask: TextView = view.findViewById(R.id.tvTask)

    fun render(task: Task) {
        tvTask.text = task.name
    }
}
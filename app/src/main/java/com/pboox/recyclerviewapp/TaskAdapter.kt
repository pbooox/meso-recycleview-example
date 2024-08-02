package com.pboox.recyclerviewapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pboox.recyclerviewapp.R


class TaskAdapter(private var tasks: List<Task>) :
    RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
//    crea un inflador de vista, necesita un contexto. infla la vista
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
//    retorna un viewholder(cada vista) por cada item
        return TaskViewHolder(view)

    }

//  le pasamos la informacion a cada holder segun la posicion de la vista
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position])
    }

//    imprime la cantidad de items que le indiquemos
    override fun getItemCount() = tasks.size

}

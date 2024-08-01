package com.pboox.recyclerviewapp

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pboox.recyclerviewapp.R

private lateinit var rvTasks: RecyclerView
private lateinit var taskAdapter: TaskAdapter

private lateinit var fabAddTask: FloatingActionButton

private val tasks = mutableListOf(
    Task("comprar agua"),
    Task("pagar luz"),
    Task("pagar telefono")
)

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponets()
        initUI()
        initListeners()

    }

    private fun initListeners() {
        fabAddTask.setOnClickListener(){
            showDialog()
        }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)


        btnAddTask.setOnClickListener{
            val currentTask = etTask.text.toString()
            if(currentTask.isNotEmpty()){
                tasks.add(Task(etTask.text.toString()))
                updateTasks()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun initComponets() {
        rvTasks = findViewById (R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
//        crear un adaptador (clase que conecta la informacion con el recyclerview)
//        crear un viewholder (clase que imprime)


//        le mandamos al adapdator la lista de tasks que se van a imprimir
        taskAdapter = TaskAdapter(tasks)
//        agregamos un layoutmanager que decide si la vista sera vertical o horizontal
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        le pasamos al recyclerview el adaptador con la data
        rvTasks.adapter = taskAdapter
    }

    private fun updateTasks() {
        taskAdapter.notifyDataSetChanged()
    }
}
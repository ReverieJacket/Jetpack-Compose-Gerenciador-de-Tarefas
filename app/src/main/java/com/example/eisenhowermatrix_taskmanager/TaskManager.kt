package com.example.eisenhowermatrix_taskmanager

import androidx.collection.mutableIntListOf

object TaskManager {
    private val taskList = mutableListOf<Task>()

    fun getAllTasks() :List<Task>{
        return taskList
    }
    fun addTask(title : String, description : String){
        taskList.add(Task(System.currentTimeMillis().toInt(), title, description))
    }

    fun deleteTask(id : Int ){
        taskList.removeIf{
            it.id == id
        }
    }

}
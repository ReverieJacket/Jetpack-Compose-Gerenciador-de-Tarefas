package com.example.eisenhowermatrix_taskmanager.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eisenhowermatrix_taskmanager.Task
import com.example.eisenhowermatrix_taskmanager.TaskManager

class TaskViewModel: ViewModel() {
    private var _taskList = MutableLiveData<List<Task>>()
    val taskList : LiveData<List<Task>> = _taskList

    fun getAllTasks(){
        _taskList.value = TaskManager.getAllTasks().reversed()
    }
    fun addTask(title : String, description : String){
        TaskManager.addTask(title, description)
        getAllTasks()
    }

    fun deleteTask(id : Int){
        TaskManager.deleteTask(id)
        getAllTasks()
    }

}
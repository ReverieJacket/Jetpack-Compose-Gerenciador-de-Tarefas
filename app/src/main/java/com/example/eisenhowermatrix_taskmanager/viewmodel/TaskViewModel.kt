package com.example.eisenhowermatrix_taskmanager.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eisenhowermatrix_taskmanager.Task
import com.example.eisenhowermatrix_taskmanager.TaskCategory
import com.example.eisenhowermatrix_taskmanager.TaskManager

class TaskViewModel : ViewModel() {
    private var _taskList = MutableLiveData<List<Task>>()
    val taskList: LiveData<List<Task>> = _taskList

    fun getAllTasks() {
        _taskList.value = TaskManager.getAllTasks().reversed()
    }

    fun addTask(title: String, description: String, category: String) {
        TaskManager.addTask(title, description, category)
        getAllTasks()
    }

    fun deleteTask(id: Int) {
        TaskManager.deleteTask(id)
        getAllTasks()
    }

    // Função para filtrar por categoria
    fun filterTasksByCategory(category: TaskCategory) {
        _taskList.value = TaskManager.getAllTasks().filter { it.category == category }.reversed()
    }
}
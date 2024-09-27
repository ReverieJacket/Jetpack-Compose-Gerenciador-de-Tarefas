package com.example.eisenhowermatrix_taskmanager

object TaskManager {
    private val taskList = mutableListOf<Task>()

    fun getAllTasks(): List<Task> {
        return taskList
    }

    fun addTask(title: String, description: String, category: String) {
        taskList.add(Task(System.currentTimeMillis().toInt(), title, description, TaskCategory.valueOf(category)))
    }

    fun deleteTask(id: Int) {
        taskList.removeIf { it.id == id }
    }
}

enum class TaskCategory(val value: String){
    URGENT_IMPORTANT("Urgente e importante"),
    IMPORTANT_NOT_URGENT("Importante, não urgente"),
    URGENT_NOT_IMPORTANT("Urgente, não importante"),
    NOT_URGENT_NOT_IMPORTANT("Tanto faz")
}
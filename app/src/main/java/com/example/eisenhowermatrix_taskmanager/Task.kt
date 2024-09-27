package com.example.eisenhowermatrix_taskmanager

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val category: TaskCategory
)
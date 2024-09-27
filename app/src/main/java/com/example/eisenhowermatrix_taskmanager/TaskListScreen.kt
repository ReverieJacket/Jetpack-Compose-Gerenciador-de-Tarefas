package com.example.eisenhowermatrix_taskmanager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eisenhowermatrix_taskmanager.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(viewModel: TaskViewModel, selectedCategory: TaskCategory? = null) {
    val taskList by viewModel.taskList.observeAsState()

    // Se houver uma categoria selecionada, aplique o filtro
    LaunchedEffect(selectedCategory) {
        if (selectedCategory != null) {
            viewModel.filterTasksByCategory(selectedCategory)
        } else {
            viewModel.getAllTasks()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        taskList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it) { _: Int, item: Task ->
                        TaskItem(item, onDelete = {
                            viewModel.deleteTask(item.id)
                        })
                    }
                }
            )
        }
    }
}

@Composable
fun TaskItem(item: Task, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFFFFFF))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f) // Coloca o ícone de deletar no canto
        ) {
            Text(
                text = item.title,
                color = Color.Black,
                fontSize = 20.sp
            )
            Text(
                text = item.description,
                color = Color.Gray,
                fontSize = 12.sp
            )
            Text( // Adiciona a exibição da categoria
                text = item.category.name,
                color = Color.Blue,
                fontSize = 12.sp
            )
        }
        IconButton(onClick = onDelete) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Deletar",
                tint = Color.Black
            )
        }
    }
}
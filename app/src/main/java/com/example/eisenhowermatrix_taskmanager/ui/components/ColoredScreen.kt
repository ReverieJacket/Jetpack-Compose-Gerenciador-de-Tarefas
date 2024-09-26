package com.example.eisenhowermatrix_taskmanager.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.eisenhowermatrix_taskmanager.TaskListScreen
import com.example.eisenhowermatrix_taskmanager.viewmodel.TaskViewModel

// Função composable que cria telas coloridas com um texto centralizado.
@Composable
fun ColoredScreen(color: Color, title: String, taskViewModel: TaskViewModel) {

    Column(
        Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp), Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
    TaskListScreen(taskViewModel)
}

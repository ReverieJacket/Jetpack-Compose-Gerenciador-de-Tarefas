package com.example.eisenhowermatrix_taskmanager

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eisenhowermatrix_taskmanager.viewmodel.TaskViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskListScreen(viewModel: TaskViewModel){
    val taskList by viewModel.taskList.observeAsState()
    var inputText by remember { mutableStateOf("") }
    var inputText1 by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
            verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        OutlinedTextField(
            value = inputText,
            onValueChange = {inputText = it})
        OutlinedTextField(
            value = inputText1,
            onValueChange = {inputText1 = it})

        Button(modifier = Modifier.padding(5.dp), onClick = {viewModel.addTask(inputText, inputText1)
        inputText = ""; inputText1 = ""}) {
            Text(text = "Add")
        }
        taskList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it){ index: Int, item: Task ->
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
fun TaskItem(item: Task, onDelete : ()->Unit){
    Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(8.dp)
           .clip(RoundedCornerShape(16.dp))
           .background(Color(0xFF5C06D0))
           .padding(16.dp)


    ){
        Column(
            modifier = Modifier.weight(1f) // coloca o icône deletar no canto
        ){
            Text(text = item.title,
                color = Color.White,
                fontSize = 20.sp
            )
            Text(text = item.description,
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
        IconButton(onClick = onDelete) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Deletar",
                tint = Color.White
            )
        }
    }
}
package com.example.eisenhowermatrix_taskmanager.ui.addtask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.eisenhowermatrix_taskmanager.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(viewModel: TaskViewModel) {
    var inputText by remember { mutableStateOf("") }
    var inputText1 by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("Selecionar Categoria") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Text(
            text = "Adicionar Tarefa",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = inputText1,
            onValueChange = { inputText1 = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                readOnly = true,
                value = selectedCategory,
                onValueChange = {},
                label = { Text("Categoria") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(MenuAnchorType.PrimaryEditable, true)
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(text = { Text("Urgente e importante") }, onClick = {
                    selectedCategory = "Urgente e importante"
                    expanded = false
                })
                DropdownMenuItem(text = { Text("Importante, não urgente") }, onClick = {
                    selectedCategory = "Importante, não urgente"
                    expanded = false
                })
                DropdownMenuItem(text = { Text("Urgente, não importante") }, onClick = {
                    selectedCategory = "Urgente, não importante"
                    expanded = false
                })
                DropdownMenuItem(text = { Text("Tanto faz") }, onClick = {
                    selectedCategory = "Tanto faz"
                    expanded = false
                })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if(selectedCategory != "Selecionar Categoria"){
                    viewModel.addTask(inputText, inputText1, selectedCategory)
                    inputText = ""
                    inputText1 = ""
                    selectedCategory = "Selecionar Categoria"
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Salvar Tarefa", color = Color.White)
        }
    }
}
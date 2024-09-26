package com.example.eisenhowermatrix_taskmanager.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.eisenhowermatrix_taskmanager.ui.components.DashboardCard
import com.example.eisenhowermatrix_taskmanager.ui.components.DashboardHeader


@Composable
fun DashboardScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))
            .padding(12.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DashboardHeader(navController = navController)

        DashboardCard(
            backgroundColor = Color(0xFF64D37E),
            title = "Faça agora!",
            subtitle = "Urgente e Importante",
            onClick = { navController.navigate("green_screen") }
        )

        DashboardCard(
            backgroundColor = Color(0xFF4F96F1),
            title = "Decida quando fazer!",
            subtitle = "Importante, Não Urgente",
            onClick = { navController.navigate("blue_screen") }
        )

        DashboardCard(
            backgroundColor = Color(0xFFFFAA38),
            title = "Delegue!",
            subtitle = "Urgente, Não Importante",
            onClick = { navController.navigate("yellow_screen") }
        )

        DashboardCard(
            backgroundColor = Color(0xFFFF6E5B),
            title = "Arquive!",
            subtitle = "Não importante, Não Urgente",
            onClick = { navController.navigate("red_screen") }
        )
        FloatingActionButton(
            onClick = { navController.navigate("add_task") },
            modifier = Modifier
                .align(Alignment.End),
            containerColor = Color.Black
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Adicionar Tarefa",
                tint = Color.White // White "+" icon
            )
        }

    }
}
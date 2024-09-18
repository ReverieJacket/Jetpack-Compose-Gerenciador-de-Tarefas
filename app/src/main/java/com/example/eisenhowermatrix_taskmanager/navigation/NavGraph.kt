package com.example.eisenhowermatrix_taskmanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eisenhowermatrix_taskmanager.ui.addtask.AddTaskScreen
import com.example.eisenhowermatrix_taskmanager.ui.components.ColoredScreen
import com.example.eisenhowermatrix_taskmanager.ui.dashboard.DashboardScreen

// Função composable que configura o grafo de navegação do app.
// Define as rotas para as diferentes telas que podem ser acessadas via o navController.
@Composable
fun SetupNavGraph(navController: NavHostController) {
    // Define o NavHost, onde o navController controla a navegação entre as telas.
    NavHost(
        navController = navController,
        startDestination = "dashboard"
    ) {
        // Rota para a tela "dashboard".
        composable("dashboard") {
            DashboardScreen(navController)
        }
        // Rota para a tela verde.
        composable("green_screen") {
            ColoredScreen(color = Color(0xFF64D37E), title = "Faça agora!")
        }
        // Rota para a tela azul.
        composable("blue_screen") {
            ColoredScreen(color = Color(0xFF4F96F1), title = "Decida quando fazer!")
        }
        // Rota para a tela amarela.
        composable("yellow_screen") {
            // Chama uma tela colorida com fundo amarelo e título "Delegue".
            ColoredScreen(color = Color(0xFFFFAA38), title = "Delegue")
        }
        // Rota para a tela vermelha.
        composable("red_screen") {
            ColoredScreen(color = Color(0xFFFF6E5B), title = "Elimine!")
        }
        // Rota para a tela de adicionar tarefa
        composable("add_task") {
            AddTaskScreen(navController)
        }
    }
}

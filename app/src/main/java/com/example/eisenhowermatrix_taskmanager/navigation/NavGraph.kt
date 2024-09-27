package com.example.eisenhowermatrix_taskmanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eisenhowermatrix_taskmanager.R
import com.example.eisenhowermatrix_taskmanager.TaskListScreen
import com.example.eisenhowermatrix_taskmanager.ui.about.AntonioProfile
import com.example.eisenhowermatrix_taskmanager.ui.about.MarcusProfile
import com.example.eisenhowermatrix_taskmanager.ui.about.MateusProfile
import com.example.eisenhowermatrix_taskmanager.ui.about.PauloProfile
import com.example.eisenhowermatrix_taskmanager.ui.addtask.AddTaskScreen
import com.example.eisenhowermatrix_taskmanager.ui.components.ColoredScreen
import com.example.eisenhowermatrix_taskmanager.ui.components.InfoScreen
import com.example.eisenhowermatrix_taskmanager.ui.dashboard.DashboardScreen
import com.example.eisenhowermatrix_taskmanager.viewmodel.TaskViewModel

// Função composable que configura o grafo de navegação do app.
// Define as rotas para as diferentes telas que podem ser acessadas via o navController.
@Composable
fun SetupNavGraph(navController: NavHostController, viewModel: TaskViewModel) {
    // Define o NavHost, onde o navController controla a navegação entre as telas.
    NavHost(
        navController = navController,
        startDestination = "dashboard"
    ) {
        // Rota para a tela "dashboard".
        composable("dashboard") {
            DashboardScreen(navController)
        }
        composable("task_list_screen") {
            TaskListScreen(viewModel = viewModel)
        }
        // Rota para a tela verde.
        composable("green_screen") {
            ColoredScreen(color = Color(0xFF64D37E), title = "Faça agora!", viewModel)
        }
        // Rota para a tela azul.
        composable("blue_screen") {
            ColoredScreen(color = Color(0xFF4F96F1), title = "Decida quando fazer!", viewModel)
        }
        // Rota para a tela amarela.
        composable("yellow_screen") {
            // Chama uma tela colorida com fundo amarelo e título "Delegue".
            ColoredScreen(color = Color(0xFFFFAA38), title = "Delegue", viewModel)
        }
        // Rota para a tela vermelha.
        composable("red_screen") {
            ColoredScreen(color = Color(0xFFFF6E5B), title = "Elimine!", viewModel)
        }
        composable(route = "info_screen") {
            InfoScreen(navController) // Substitua pela função da sua nova tela
        }
        composable("paulo_screen") {
            PauloProfile(
                stringResource(R.string.nome),
                stringResource(R.string.profissao),
                stringResource(R.string.actualProfissao),
                stringResource(R.string.email),
                stringResource(R.string.github),
                stringResource(R.string.telefone)
            )
        }
        composable("marcus_screen") {
            MarcusProfile()
        }
        composable("mateus_screen") {
            MateusProfile()
        }
        composable("antonio_screen") {
            AntonioProfile()
        }
        // Rota para a tela de adicionar tarefa
        composable("add_task") {
            AddTaskScreen(viewModel)
        }
    }
}

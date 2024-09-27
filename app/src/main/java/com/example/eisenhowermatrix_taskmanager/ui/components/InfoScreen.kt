package com.example.eisenhowermatrix_taskmanager.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun InfoScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))
            .padding(12.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Título da tela
        Text(
            text = "Tela sobre",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Cards brancos para informações
        DashboardCard(
            backgroundColor = Color.DarkGray,
            title = "Mateus Falcão",
            subtitle = "Cartão visita para mais informações",
            onClick = { navController.navigate("mateus_screen") }
        )

        DashboardCard(
            backgroundColor = Color.DarkGray,
            title = "Antonio Henrique",
            subtitle = "Descreva funcionalidades ou informações úteis.",
            onClick = { /* Ação opcional, pode deixar vazio */ }
        )

        DashboardCard(
            backgroundColor = Color(0xFF64D37E),
            title = "Marcus Vinicius",
            subtitle = "Informações para contato.",
            onClick = { navController.navigate("marcus_screen") }
        )

        DashboardCard(
            backgroundColor = Color.Red,
            title = "Paulo Sérgio",
            subtitle = "Mais detalhes sobre o funcionamento do app.",
            onClick = { navController.navigate("paulo_screen") }
        )
    }
}

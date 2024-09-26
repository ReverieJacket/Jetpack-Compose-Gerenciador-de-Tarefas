package com.example.eisenhowermatrix_taskmanager.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoScreen() {
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
            subtitle = "Aqui você pode adicionar detalhes sobre o aplicativo.",
            onClick = { /* Ação opcional, pode deixar vazio */ }
        )

        DashboardCard(
            backgroundColor = Color.DarkGray,
            title = "Antonio Henrique",
            subtitle = "Descreva funcionalidades ou informações úteis.",
            onClick = { /* Ação opcional, pode deixar vazio */ }
        )

        DashboardCard(
            backgroundColor = Color.DarkGray,
            title = "Marcos",
            subtitle = "Qualquer outro detalhe relevante.",
            onClick = { /* Ação opcional, pode deixar vazio */ }
        )

        DashboardCard(
            backgroundColor = Color.DarkGray,
            title = "Paulo Sergio",
            subtitle = "Mais detalhes sobre o funcionamento do app.",
            onClick = { /* Ação opcional, pode deixar vazio */ }
        )
    }
}

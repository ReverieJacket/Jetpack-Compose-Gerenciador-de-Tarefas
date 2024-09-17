package com.example.eisenhowermatrix_taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eisenhowermatrix_taskmanager.ui.theme.EisenhowerMatrixTaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EisenhowerMatrixTaskManagerTheme {
                DashboardScreen()
            }
        }
    }
}

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB)) // Background cinza claro da tela
            .padding(12.dp) // Distância das bordas da tela
            .windowInsetsPadding(WindowInsets.systemBars), //
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaçamento entre os cartões
    ) {
        DashboardCard(
            backgroundColor = Color(0xFF64D37E), // Verde
            title = "Faça agora!",
            subtitle = "Urgente e Importante"
        )
        DashboardCard(
            backgroundColor = Color(0xFF4F96F1), // Azul
            title = "Decida quando fazer!",
            subtitle = "Importante, Não Urgente"
        )
        DashboardCard(
            backgroundColor = Color(0xFFFFAA38), // Amarelo
            title = "Delegue!",
            subtitle = "Urgente, Não Importante"
        )
        DashboardCard(
            backgroundColor = Color(0xFFFF6E5B), // Vermelho
            title = "Elimine!",
            subtitle = "Não importante, Não Urgente"
        )
    }
}

@Composable
fun DashboardCard(
    backgroundColor: Color,
    title: String,
    subtitle: String
    // precisa ter um valor para o número de tarefas
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors =  CardDefaults.cardColors(
            containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )

        }
    }
}

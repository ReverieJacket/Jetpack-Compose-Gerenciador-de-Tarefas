package com.example.eisenhowermatrix_taskmanager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eisenhowermatrix_taskmanager.ui.theme.EisenhowerMatrixTaskManagerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EisenhowerMatrixTaskManagerTheme {
                // Cria e lembra o controlador de navegação que gerencia a troca de telas.
                val navController = rememberNavController()

                // Configura o grafo de navegação, passando o navController para definir as rotas das telas.
                SetupNavGraph(navController = navController)
            }
        }
    }
}

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

@Composable
fun DashboardHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Título
        Text(
            text = "Minhas Tarefas",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Ícones
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp) // Espaçamento entre os ícones
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                modifier = Modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

// Função composable que define o layout e comportamento de cada cartão no dashboard.
@Composable
fun DashboardCard(
    backgroundColor: Color,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    // Define um cartão com largura total e altura fixa, que reage a cliques.
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
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
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold

            )

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
        }
    }
}


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
        DashboardHeader()

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

// Função composable que cria telas coloridas com um texto centralizado.
@Composable
fun ColoredScreen(color: Color, title: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(navController: NavHostController) {
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
            value = "",
            onValueChange = {},
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        var expanded by remember { mutableStateOf(false) }
        var selectedCategory by remember { mutableStateOf("Selecionar Categoria") }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                readOnly = true,
                value = selectedCategory,
                onValueChange = {},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(text = { Text("Category 1") }, onClick = {
                    selectedCategory = "Category 1"
                    expanded = false
                })
                DropdownMenuItem(text = { Text("Category 2") }, onClick = {
                    selectedCategory = "Category 2"
                    expanded = false
                })
                DropdownMenuItem(text = { Text("Category 3") }, onClick = {
                    selectedCategory = "Category 3"
                    expanded = false
                })
                DropdownMenuItem(text = { Text("Category 4") }, onClick = {
                    selectedCategory = "Category 4"
                    expanded = false
                })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { /* Save the task */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Salvar Tarefa", color = Color.White)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    EisenhowerMatrixTaskManagerTheme {
        DashboardScreen(rememberNavController())
    }
}


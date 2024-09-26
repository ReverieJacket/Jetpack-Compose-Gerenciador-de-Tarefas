package com.example.eisenhowermatrix_taskmanager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.eisenhowermatrix_taskmanager.navigation.SetupNavGraph
import com.example.eisenhowermatrix_taskmanager.ui.theme.EisenhowerMatrixTaskManagerTheme
import com.example.eisenhowermatrix_taskmanager.viewmodel.TaskViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taskViewModel = ViewModelProvider(this)[TaskViewModel:: class.java]
        enableEdgeToEdge()
        setContent {
            EisenhowerMatrixTaskManagerTheme {
                // Cria e lembra o controlador de navegação que gerencia a troca de telas.
                val navController = rememberNavController()
                // Configura o grafo de navegação, passando o navController para definir as rotas das telas.
                SetupNavGraph(navController = navController, viewModel = taskViewModel)
            }
        }
    }
}

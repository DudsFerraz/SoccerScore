package br.edu.ifsp.scl.sc3043959.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SoccerScoreApp()
                }
            }
        }
    }
}

// @Composable que gerencia as rotas do aplicativo
@Composable
fun SoccerScoreApp() {
    // estado para armazenar e controlar a navegacao
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tela1") {
        // rota para a Tela 1
        composable("tela1") {
            Configuracao(navController)
        }

        // rota para a Tela 2 recebendo parametros
        composable(
            route = "tela2/{timeA}/{timeB}/{golsA}/{golsB}",
            arguments = listOf(
                navArgument("timeA") { type = NavType.StringType },
                navArgument("timeB") { type = NavType.StringType },
                navArgument("golsA") { type = NavType.IntType },
                navArgument("golsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            // recebe os parametros passados pela rota origem
            val timeA = backStackEntry.arguments?.getString("timeA") ?: ""
            val timeB = backStackEntry.arguments?.getString("timeB") ?: ""
            val golsA = backStackEntry.arguments?.getInt("golsA") ?: 0
            val golsB = backStackEntry.arguments?.getInt("golsB") ?: 0

            Resumo(navController, timeA, timeB, golsA, golsB)
        }

        // rota para a Tela 3 recebendo parametros
        composable(
            route = "tela3/{timeA}/{timeB}/{golsA}/{golsB}",
            arguments = listOf(
                navArgument("timeA") { type = NavType.StringType },
                navArgument("timeB") { type = NavType.StringType },
                navArgument("golsA") { type = NavType.IntType },
                navArgument("golsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            // recebe os parametros passados pela rota origem
            val timeA = backStackEntry.arguments?.getString("timeA") ?: ""
            val timeB = backStackEntry.arguments?.getString("timeB") ?: ""
            val golsA = backStackEntry.arguments?.getInt("golsA") ?: 0
            val golsB = backStackEntry.arguments?.getInt("golsB") ?: 0

            Resultado(navController, timeA, timeB, golsA, golsB)
        }
    }
}
package br.edu.ifsp.scl.sc3043959.soccerscore

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// @Composable descreve a UI da Tela de resultado
@Composable
fun Resultado(navController: NavController, timeA: String, timeB: String, golsA: Int, golsB: Int) {

    val mensagemResultado = when {
        golsA > golsB -> "$timeA venceu!"
        golsB > golsA -> "$timeB venceu!"
        else -> "Empate emocionante!"
    }

    // Column organiza os elementos na vertical
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Resultado Final", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // exibe a mensagem de vitoria ou empate
        Text(
            text = mensagemResultado,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // botao para iniciar um novo jogo
        Button(
            onClick = {
                // retorna para a tela de configuracao e limpa o historico de navegacao (backstack) para impedir que o botao voltar do android retorne a esta tela
                navController.navigate("tela1") {
                    popUpTo("tela1") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Novo Jogo")
        }
    }
}
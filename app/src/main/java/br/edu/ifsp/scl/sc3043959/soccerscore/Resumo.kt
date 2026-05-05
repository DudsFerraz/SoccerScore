package br.edu.ifsp.scl.sc3043959.soccerscore

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// @Composable descreve a UI da Tela de resumo
@Composable
fun Resumo(navController: NavController, timeA: String, timeB: String, golsA: Int, golsB: Int) {
    // Column organiza os elementos na vertical
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Resumo da Partida", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // exibe os nomes dos times
        Text(text = "$timeA vs $timeB", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        // exibe o placar da partida
        Text(text = "Placar: $golsA x $golsB", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(32.dp))

        // Row organiza os botoes lado a lado
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // botao editar
            Button(
                onClick = {
                    // popBackStack() retorna para a tela anterior (Configuracao)
                    // os dados sao mantidos graças ao rememberSaveable na Tela 1
                    navController.popBackStack()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Editar")
            }

            Spacer(modifier = Modifier.width(16.dp))

            // botao confirmar resultado
            Button(
                onClick = {
                    // navega para a tela de resultado repassando os parametros recebidos
                    navController.navigate("tela3/$timeA/$timeB/$golsA/$golsB")
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Confirmar")
            }
        }
    }
}
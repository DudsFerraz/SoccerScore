package br.edu.ifsp.scl.sc3043959.soccerscore

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// @Composable descreve a UI da Tela de configuracao
@Composable
fun Configuracao(navController: NavController) {
    val context = LocalContext.current

    // estados para armazenar as entradas do usuario preservando durante a rotacao da tela
    var timeA by rememberSaveable { mutableStateOf("") }
    var timeB by rememberSaveable { mutableStateOf("") }
    var golsA by rememberSaveable { mutableStateOf("") }
    var golsB by rememberSaveable { mutableStateOf("") }

    // Column organiza os elementos na vertical
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Configuração da Partida", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // secao do time A
        OutlinedTextField(
            value = timeA,
            onValueChange = { timeA = it },
            label = { Text("Nome do Time A") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = golsA,
            onValueChange = { golsA = it },
            label = { Text("Gols do Time A") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // secao do time B
        OutlinedTextField(
            value = timeB,
            onValueChange = { timeB = it },
            label = { Text("Nome do Time B") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = golsB,
            onValueChange = { golsB = it },
            label = { Text("Gols do Time B") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // botao para validar os dados e navegar para a tela de resumo
        Button(
            onClick = {
                // tenta converter os gols para inteiro, retorna null se for invalido
                val golsAInt = golsA.toIntOrNull()
                val golsBInt = golsB.toIntOrNull()

                // validacao de preenchimento e tipo
                if (timeA.isNotBlank() && timeB.isNotBlank() && golsAInt != null && golsBInt != null) {
                    if (golsAInt >= 0 && golsBInt >= 0) {
                        navController.navigate("tela2/$timeA/$timeB/$golsAInt/$golsBInt")
                    } else {
                        Toast.makeText(context, "Os gols devem ser maiores ou iguais a zero", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Resultado")
        }
    }
}
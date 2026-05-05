package br.edu.ifsp.scl.sc3043959.soccerscore

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

// @Composable descreve a UI da Tela 2
@Composable
fun Resumo(navController: NavController, timeA: String, timeB: String, golsA: Int, golsB: Int) {
    Text("Stub da Tela 2 - Resumo: $timeA $golsA x $golsB $timeB")
}
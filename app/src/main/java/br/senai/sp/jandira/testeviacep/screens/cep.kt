package br.senai.sp.jandira.testeviacep.screens

import androidx.compose.foundation.background
import br.senai.sp.jandira.testeviacep.service.RetrofitClient


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TelaCep() {
    val coroutineScope = rememberCoroutineScope()

    var cep by remember { mutableStateOf("") }
    var logradouro by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var uf by remember { mutableStateOf("") }

    Card (
        modifier = Modifier
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = cep,
                onValueChange = { cep = it },
                label = { Text("CEP") },
                trailingIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            try {
                                val response = RetrofitClient.api.buscarEndereco(cep).execute()
                                if (response.isSuccessful) {
                                    val endereco = response.body()
                                    logradouro = endereco?.logradouro ?: ""
                                    bairro = endereco?.bairro ?: ""
                                    uf = endereco?.uf ?: ""
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }) {
                        Icon(Icons.Default.Search, contentDescription = "Buscar")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = logradouro,
                onValueChange = {},
                label = { Text("Logradouro") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = bairro,
                onValueChange = {},
                label = { Text("Bairro") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = uf,
                onValueChange = {},
                label = { Text("UF") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun TelaCepPreview() {
    TelaCep()
}

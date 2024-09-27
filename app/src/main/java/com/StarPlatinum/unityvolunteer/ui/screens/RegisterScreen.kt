package com.StarPlatinum.unityvolunteer.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.StarPlatinum.unityvolunteer.R
import com.StarPlatinum.unityvolunteer.viewmodel.LoginViewModel
import com.StarPlatinum.unityvolunteer.viewmodel.RegisterViewModel

// Vista de registro
@Composable
fun RegisterScreen(viewModel: RegisterViewModel, onRegisterSuccess: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = R.drawable.unitylogo,  // Imagen desde los recursos locales
            contentDescription = "Local Image",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = viewModel.apellido,
            onValueChange = { viewModel.onApellidoChange(it) },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = viewModel.pais,
            onValueChange = { viewModel.onPaisChange(it) },
            label = { Text("País") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = viewModel.region,
            onValueChange = { viewModel.onRegionChange(it) },
            label = { Text("Región") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = viewModel.distrito,
            onValueChange = { viewModel.onDistritoChange(it) },
            label = { Text("Distrito") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para registrar y redirigir al login
        Button(
            onClick = {
                viewModel.register()
                onRegisterSuccess()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(viewModel= RegisterViewModel(),onRegisterSuccess = { /* Simular comportamiento de registro */ })
}
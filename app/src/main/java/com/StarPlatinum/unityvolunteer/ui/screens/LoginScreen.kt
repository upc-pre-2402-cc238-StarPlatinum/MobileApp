package com.StarPlatinum.unityvolunteer.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.StarPlatinum.unityvolunteer.R
import com.StarPlatinum.unityvolunteer.viewmodel.LoginViewModel


@Composable
fun LoginScreen(viewModel: LoginViewModel, onLoginSuccess: () -> Unit, onRegisterButton: ()-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(),  // Ocupa toda la pantalla
        contentAlignment = Alignment.Center  // Centra el contenido
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally  // Alinea el contenido horizontalmente en el centro
        ) {
            AsyncImage(
                model = R.drawable.unitylogo,  // Imagen desde los recursos locales
                contentDescription = "Local Image",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = viewModel.email,
                onValueChange = { viewModel.onEmailChange(it) },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = viewModel.password,
                onValueChange = { viewModel.onPasswordChange(it) },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onLoginSuccess() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3894B6),  // Color de fondo del botón
                    contentColor = Color.White  // Color del texto
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Log In")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Regístrate", modifier = Modifier
                .padding(8.dp)
                .clickable { onRegisterButton()},
                Color(0xFF3894B6))

        }
    }
}
@Preview(showBackground = true)
@Composable
fun ShowLogin(){
    LoginScreen( viewModel = LoginViewModel(),
        onLoginSuccess = {},
        onRegisterButton = {})
}


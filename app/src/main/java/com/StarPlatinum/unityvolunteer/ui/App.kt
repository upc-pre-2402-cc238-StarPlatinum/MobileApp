package com.StarPlatinum.unityvolunteer.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.StarPlatinum.unityvolunteer.model.Evento
import com.StarPlatinum.unityvolunteer.ui.screens.DetallesEventoScreen
import com.StarPlatinum.unityvolunteer.ui.screens.EventosScreen
import com.StarPlatinum.unityvolunteer.ui.screens.LoginScreen
import com.StarPlatinum.unityvolunteer.ui.screens.PerfilScreen
import com.StarPlatinum.unityvolunteer.ui.screens.RegisterScreen
import com.StarPlatinum.unityvolunteer.ui.screens.usuarioEjemplo
import com.StarPlatinum.unityvolunteer.viewmodel.EventosViewModel
import com.StarPlatinum.unityvolunteer.viewmodel.LoginViewModel
import com.StarPlatinum.unityvolunteer.viewmodel.RegisterViewModel


@Composable
fun App() {
    var currentScreen by remember { mutableStateOf("login") }
    var selectedEvento by remember { mutableStateOf<Evento?>(null) }//evento selccionado

    MainScaffold(
        currentScreen = currentScreen,
        onScreenChange = { newScreen -> currentScreen = newScreen }
    ) { paddingValues ->  // Asegurarse de recibir paddingValues aquí
        when (currentScreen) {
            "login" -> LoginScreen(
                viewModel = LoginViewModel(),
                onLoginSuccess = { currentScreen = "eventos" },
                onRegisterButton={ currentScreen= "register" }
            )
            "register" -> RegisterScreen (
                viewModel = RegisterViewModel(),
                onRegisterSuccess = { currentScreen ="login"}
                )

            "perfil" -> PerfilScreen(
                usuario = usuarioEjemplo,
                  // Pasar paddingValues si es necesario
                onModificarClick = { /* Acción de modificar perfil */ }
            )

            "eventos" -> EventosScreen(
                viewModel = EventosViewModel(),
                paddingValues = paddingValues, // Pasar paddingValues a EventosScreen
                onEventoClick = {
                    evento ->
                    selectedEvento=evento
                    currentScreen = "detalles_evento"
                }
            )
              // Si tienes una pantalla de perfil
            "detalles_evento" -> selectedEvento?.let { evento ->
                DetallesEventoScreen(evento = evento, paddingValues= paddingValues, onInscribirmeClick = { /* Acción para inscribirse */ })
            }
        }
    }
}


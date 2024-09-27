package com.StarPlatinum.unityvolunteer.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    // Campos del usuario para registro
    var nombre by mutableStateOf("")
    var apellido by mutableStateOf("")
    var pais by mutableStateOf("")
    var region by mutableStateOf("")
    var distrito by mutableStateOf("")

    // Funciones para actualizar cada campo
    fun onNombreChange(newNombre: String) {
        nombre = newNombre
    }

    fun onApellidoChange(newApellido: String) {
        apellido = newApellido
    }

    fun onPaisChange(newPais: String) {
        pais = newPais
    }

    fun onRegionChange(newRegion: String) {
        region = newRegion
    }

    fun onDistritoChange(newDistrito: String) {
        distrito = newDistrito
    }

    // Función para realizar el registro
    fun register() {
        // Aquí puedes implementar la lógica para registrar al usuario, por ejemplo,
        // enviar los datos a una API o guardarlos en una base de datos local.
    }
}
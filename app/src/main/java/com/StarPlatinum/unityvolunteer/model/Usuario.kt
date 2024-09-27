package com.StarPlatinum.unityvolunteer.model

data class Usuario(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val pais: String,
    val region: String,
    val distrito: String,
    val genero: String,  // Nuevo campo para género
    val cumpleaños: String,  // Nuevo campo para la fecha de nacimiento
    val status: String,  // Nuevo campo para el estado (estudiante, etc.)
    val metodoPago: String,  // Nuevo campo para el método de pago
    val fotoPerfilUrl: String  // URL o recurso local para la foto de perfil
)
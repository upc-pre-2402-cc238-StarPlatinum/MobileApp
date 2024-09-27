package com.StarPlatinum.unityvolunteer.model

data class Evento(
    val id: Int,
    val nombre: String,
    val fecha: String,  // Podrías usar Date/Time si quieres manejar fechas y horas más complejas
    val lugar: String,
    val participantes: Int,
    val imagenUrl: String,
    val descripcion: String,  // Resumen de la actividad
    val nivelDificultad: Int,  // Nivel de dificultad del 1 al 10
    val personasInscritas: Int,  // Número de personas inscritas
    val cantidadDias: Int  // Duración del evento en días

)
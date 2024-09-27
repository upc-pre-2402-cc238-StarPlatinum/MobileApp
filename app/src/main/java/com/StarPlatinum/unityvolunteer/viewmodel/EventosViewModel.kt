package com.StarPlatinum.unityvolunteer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.StarPlatinum.unityvolunteer.model.Evento
class EventosViewModel : ViewModel() {
    private val _eventos = MutableLiveData<List<Evento>>()
    val eventos: LiveData<List<Evento>> = _eventos

    init {
        loadEventos()
    }

    private fun loadEventos() {
        _eventos.value = listOf(
            Evento(
                id = 1,
                nombre = "Limpieza Playa Ancón",
                fecha = "27/07/2024",
                lugar = "Ancón, Lima",
                participantes = 20000,
                imagenUrl = "https://cdn.www.gob.pe/uploads/document/file/2468163/F1486.jpg",
                descripcion = "Un día de limpieza en las playas de Ancón, ayudando a preservar el ecosistema.",
                nivelDificultad = 5,
                personasInscritas = 100,
                cantidadDias = 1
            ),
            Evento(
                id = 2,
                nombre = "Chocolatada Colegio 1027",
                fecha = "05/08/2024",
                lugar = "Lima, Lima",
                participantes = 15000,
                imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXTElOvVl6aILsrG9ZynaUeJC-kbNuJFnbEA&s",
                descripcion = "Evento navideño para compartir una chocolatada con los niños del colegio 1027.",
                nivelDificultad = 3,
                personasInscritas = 50,
                cantidadDias = 1
            )
        )
    }
}
package com.StarPlatinum.unityvolunteer.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.StarPlatinum.unityvolunteer.model.Evento
import com.StarPlatinum.unityvolunteer.viewmodel.EventosViewModel

@Composable
fun EventosScreen(viewModel: EventosViewModel, paddingValues: PaddingValues, onEventoClick: (Evento) -> Unit) {
    val eventos by viewModel.eventos.observeAsState(emptyList())

    LazyColumn (modifier = Modifier
        .padding(paddingValues)
        .padding(16.dp)){
        items(eventos) { evento ->
            EventoItem(evento){
                onEventoClick(evento)
            }
        }
    }
}


@Composable
fun EventoItem(evento: Evento, onClick:()->Unit) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth().clickable { onClick() }) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = evento.imagenUrl,  // La URL de la imagen
                contentDescription = "Imagen del evento",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),  // Ajustar el tamaño de la imagen
                contentScale = ContentScale.Crop  // Ajustar la imagen dentro del Card
            )
            Text(evento.nombre)
            Text("${evento.fecha} - ${evento.lugar}")
            Text("Participantes: ${evento.participantes}")
        }
    }
}

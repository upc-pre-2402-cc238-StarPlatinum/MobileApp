package com.StarPlatinum.unityvolunteer.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.StarPlatinum.unityvolunteer.model.Evento

@Composable
fun DetallesEventoScreen(evento: Evento, paddingValues: PaddingValues, onInscribirmeClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            ,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la imagen del evento
        AsyncImage(
            model = evento.imagenUrl,
            contentDescription = "Imagen del evento",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Título del evento
        Text(
            text = evento.nombre,
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Nivel de dificultad y personas inscritas
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Nivel de dificultad", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("${evento.nivelDificultad}/10", style = MaterialTheme.typography.bodyMedium)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Personas ya inscritas", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text("${evento.personasInscritas}", style = MaterialTheme.typography.bodyMedium)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Descripción del evento
        Text("Descripción", style = MaterialTheme.typography.bodyMedium)
        Text(evento.descripcion, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Información de fechas y duración
        Text("Fechas", style = MaterialTheme.typography.bodySmall)
        Text(
            "Duración: ${evento.cantidadDias} días\nFechas: ${evento.fecha}",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para inscribirse
        Button(
            onClick = { onInscribirmeClick() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3894B6),
                contentColor = Color.White
            )
        ) {
            Text("Inscribirme")
        }
    }
}
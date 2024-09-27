package com.StarPlatinum.unityvolunteer.ui.screens
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import com.StarPlatinum.unityvolunteer.model.Usuario

@Composable
fun PerfilScreen(usuario: Usuario, onModificarClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto de perfil, centrada y con borde redondeado
        AsyncImage(
            model = usuario.fotoPerfilUrl,
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre completo en estilo grande y centrado
        Text(
            text = "${usuario.nombre} ${usuario.apellido}",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Información del usuario estilizada
        UserInfoRow(label = "Género", value = usuario.genero)
        UserInfoRow(label = "Cumpleaños", value = usuario.cumpleaños)
        UserInfoRow(label = "Status", value = usuario.status)
        UserInfoRow(label = "Dirección", value = "${usuario.distrito}, ${usuario.region}, ${usuario.pais}")
        UserInfoRow(label = "Método de Pago", value = usuario.metodoPago)

        Spacer(modifier = Modifier.height(32.dp))

        // Botón estilizado para modificar perfil
        Button(
            onClick = onModificarClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = MaterialTheme.shapes.medium,  // Esquinas redondeadas
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8800),  // Color más cercano al mockup
                contentColor = Color.White
            )
        ) {
            Text("Modificar", fontSize = 16.sp)
        }
    }
}

@Composable
fun UserInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),  // Mayor separación entre elementos
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 16.sp)
        Text(text = value, textAlign = TextAlign.End, modifier = Modifier.weight(1f), fontSize = 16.sp)
    }
}

val usuarioEjemplo = Usuario(
    id = 1,
    nombre = "Santiago",
    apellido = "Olivera",
    pais = "Perú",
    region = "Lima",
    distrito = "SMP",
    genero = "Masculino",
    cumpleaños = "27/07/2002",
    status = "Estudiante",
    metodoPago = "2002xxxx",
    fotoPerfilUrl = "https://www.example.com/perfil.jpg"  // URL simulada para la foto
)

@Preview(showBackground = true)
@Composable
fun PerfilScreenPreview() {
    PerfilScreen(
        usuario = usuarioEjemplo,
        onModificarClick = { /* Acción de modificar perfil */ }
    )
}

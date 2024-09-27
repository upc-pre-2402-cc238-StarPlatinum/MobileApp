package com.StarPlatinum.unityvolunteer.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.StarPlatinum.unityvolunteer.R

import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScaffold(
    currentScreen: String,
    onScreenChange: (String) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Contenido del sidebar
            DrawerContent(
                onItemSelected = { selectedItem ->
                    onScreenChange(selectedItem)
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                if (currentScreen != "login") {
                    TopBar(onOpenDrawer = { scope.launch { drawerState.open() } })
                }
            },
            content = {
                    paddingValues -> content(paddingValues)

            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onOpenDrawer: () -> Unit) {
    TopAppBar(
        modifier = Modifier
            .windowInsetsPadding( // Ajusta el TopBar para evitar áreas no seguras
                WindowInsets.systemBars.only(WindowInsetsSides.Bottom)
            ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = R.drawable.unitylogo,  // Imagen desde los recursos locales
                    contentDescription = "Logo de Unity Volunteer",
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Fit
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { onOpenDrawer() }) {
                Icon(Icons.Default.Menu, contentDescription = "Abrir menú")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF3894B6),  // Color del fondo del TopBar
            titleContentColor = Color.White,     // Color del texto
            navigationIconContentColor = Color.White  // Color del ícono de menú
        )
    )
}

@Preview(showBackground = true)
@Composable
fun showtopappbarpreview(){

    MainScaffold(currentScreen = "", onScreenChange = {}) {

    }
}


@Composable
fun DrawerContent(onItemSelected: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color.White)
            .fillMaxHeight()
        ) {
        Text("Perfil", modifier = Modifier
            .padding(8.dp)
            .clickable { onItemSelected("perfil") })
        Spacer(modifier = Modifier.height(16.dp))
        Text("Tus eventos", modifier = Modifier
            .padding(8.dp)
            .clickable { onItemSelected("eventos") })
        Spacer(modifier = Modifier.height(16.dp))
        Text("Cerrar sesión", modifier = Modifier
            .padding(8.dp)
            .clickable { onItemSelected("login") })
    }
}
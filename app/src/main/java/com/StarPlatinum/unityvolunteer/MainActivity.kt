package com.StarPlatinum.unityvolunteer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface


import com.StarPlatinum.unityvolunteer.ui.App

import com.StarPlatinum.unityvolunteer.ui.theme.UnityVolunteerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnityVolunteerTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    App()  // Llamada a la función App() que contiene la lógica de navegación
                }
            }
        }
    }
}


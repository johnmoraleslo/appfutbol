package com.johnmoraleslo.appfutbol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.johnmoraleslo.appfutbol.ui.screens.TeamScreen
import com.johnmoraleslo.appfutbol.ui.theme.AppFutbolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFutbolTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TeamScreen(
                        modifier = Modifier.padding(innerPadding),
                        onTeamClick = { /* TODO: navegar al detalle del equipo */ }
                    )
                }
            }
        }
    }
}

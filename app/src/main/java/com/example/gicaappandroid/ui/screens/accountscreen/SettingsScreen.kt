package com.example.gicaappandroid.ui.screens.accountscreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Configuración",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        // Opciones de configuración
        Text("Notificaciones", style = MaterialTheme.typography.bodyLarge)
        Switch(checked = true, onCheckedChange = { /* Cambiar estado */ })
        Divider()
        Text("Tema Oscuro", style = MaterialTheme.typography.bodyLarge)
        Switch(checked = false, onCheckedChange = { /* Cambiar estado */ })
    }
}
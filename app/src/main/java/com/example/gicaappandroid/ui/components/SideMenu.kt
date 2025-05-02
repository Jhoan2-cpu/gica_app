package com.example.gicaappandroid.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SideMenu(
    onClose: () -> Unit,
    selectedItem: String,
    options: List<String> = listOf(
        "Director",
        "Innovación Tecnológica",
        "Certificados",
        "Organigrama",
        "Organización",
        "Calidad",
        "Nuestra Historia",
        "Mi perfil"
    )
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)) // Fondo semitransparente
            .clickable(onClick = onClose) // Cierra al hacer clic fuera del menú
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .width(300.dp) // Ancho del menú
                .align(Alignment.CenterStart)
                .background(Color.White)
                .clickable(enabled = false) {}, // Evita que el clic cierre el menú
            shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp) // Espacio para la barra de estado
            ) {
                // Botón de cerrar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = onClose) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cerrar",
                            tint = Color.Black
                        )
                    }
                }

                // Opciones del menú
                options.forEach { item ->
                    val isSelected = item == selectedItem
                    val bgColor = if (isSelected) Color(0xFF42A5F5) else Color.Transparent
                    val textColor = if (isSelected) Color.White else Color.Black

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(bgColor)
                            .clickable { /* manejar navegación aquí */ }
                            .padding(16.dp)
                    ) {
                        Text(text = item, color = textColor, fontSize = 16.sp)
                    }
                }
            }
        }
    }
}
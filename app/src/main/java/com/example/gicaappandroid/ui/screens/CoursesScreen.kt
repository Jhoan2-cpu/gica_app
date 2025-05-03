package com.example.gicaappandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gicaappandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen() {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título
                    Text(
                        text = "Cursos Disponibles",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color(0xFFf5821d),
                        fontWeight = FontWeight.Bold
                    )

                    // Lista de cursos
                    val cursos = listOf("Curso de Kotlin", "Curso de Android", "Curso de UI/UX", "Curso de Backend", "Curso de IA", "Curso de Electrónica")
                    cursos.forEach { curso ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1B263B)),
                            elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Imagen del curso
                                Image(
                                    painter = painterResource(id = R.drawable.ic_gica_app_light),
                                    contentDescription = "Imagen del curso",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .padding(end = 16.dp)
                                )

                                // Información del curso
                                Column(
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = curso,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Descripción breve del curso.",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color(0xFFB0BEC5)
                                    )
                                }
                            }
                        }
                    }
                }
            }

}
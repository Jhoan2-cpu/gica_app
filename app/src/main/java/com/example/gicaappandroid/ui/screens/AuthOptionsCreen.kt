package com.example.gicaappandroid.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gicaappandroid.AppNavigation.AppNavigation
import com.example.gicaappandroid.R

@Composable
fun AuthOptionsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0D1B2A), // Azul muy oscuro (arriba)
                        Color(0xFF1B263B), // Azul intermedio
                        Color(0xFF415A77)  // Azul más claro (abajo)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen del logo
            Image(
                painter = painterResource(id = R.drawable.ic_gica_app_light),
                contentDescription = "Logo de la app",
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 5.dp)
            )

            // Texto de bienvenida
            Text(
                "Elija una opción para acceder.",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Caja para los botones
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { navController.navigate("login") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFf5821d))
                    ) {
                        Text("Iniciar sesión", color = Color.White)
                    }

                    Button(
                        onClick = { navController.navigate("register") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFf5821d))
                    ) {
                        Text("Registrarse", color = Color.White)
                    }

                    OutlinedButton(
                        onClick = { navController.navigate("home") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFf5821d))
                    ) {
                        Text("Entrar como invitado")
                    }
                }
            }
        }
    }
}
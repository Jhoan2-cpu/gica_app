package com.example.gicaappandroid.ui.screens.accountscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gicaappandroid.R

// Definición de colores del logo
private val AzulGica = Color(0xFF1766A1)
private val NaranjaGica = Color(0xFFF5821D)
private val GrisOscuroGica = Color(0xFF6D6E71)
private val BlancoGica = Color(0xFFFFFFFF)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "account_user_screen"
    ) {
        composable("account_user_screen") { AccountUserScreen(navController) }
        composable("edit_profile_screen") { EditProfileScreen() }
        composable("settings_screen") { SettingsScreen() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountUserScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sección de perfil
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = BlancoGica),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_gica_app_light),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(80.dp)
                            .background(AzulGica, shape = CircleShape)
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Text(
                            text = "Nombre del Usuario",
                            style = MaterialTheme.typography.headlineSmall,
                            color = AzulGica,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "usuario@email.com",
                            style = MaterialTheme.typography.bodyMedium,
                            color = GrisOscuroGica
                        )
                    }
                }
            }

            // Opciones de cuenta
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AccountOptionItem("Editar Perfil", R.drawable.ic_gica_app_light, AzulGica) {
                    navController.navigate("edit_profile_screen")
                }
                AccountOptionItem("Configuración", R.drawable.ic_gica_app_light, NaranjaGica) {
                    navController.navigate("settings_screen")
                }
                AccountOptionItem("Cerrar Sesión", R.drawable.ic_gica_app_light, GrisOscuroGica) {
                    // Acción para cerrar sesión
                }
            }
        }
    }
}

@Composable
fun AccountOptionItem(label: String, iconRes: Int, iconColor: Color, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = BlancoGica),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(iconColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = label,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = GrisOscuroGica,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
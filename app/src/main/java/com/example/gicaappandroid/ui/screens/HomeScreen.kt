package com.example.gicaappandroid.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gicaappandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .padding(16.dp)

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Encabezado
            HeaderSection()

            // Contenido principal
            MainContent()

            // Pie de página
            FooterSection()
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Bienvenido, Usuario",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFFf5821d),
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.ic_gica_app_light),
            contentDescription = "Logo de la app",
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF1B263B), shape = CircleShape)
                .padding(8.dp)
        )
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tarjeta destacada
        HighlightCard()

        // Botones de navegación
        NavigationButtons()
    }
}

@Composable
fun HighlightCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1B263B)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFf5821d),
                            Color(0xFFFF5722)
                        )
                    )
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Explora los cursos más populares",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun NavigationButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavigationButton("Cursos", R.drawable.ic_gica_app_light)
        NavigationButton("Reglamentos", R.drawable.ic_gica_app_light)
        NavigationButton("Plataformas", R.drawable.ic_gica_app_light)
    }
}

@Composable
fun NavigationButton(label: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Card(
            modifier = Modifier.size(72.dp),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = Color(0xFF415A77)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = label,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun FooterSection() {
    Text(
        text = "© 2024 GicaApp",
        style = MaterialTheme.typography.bodySmall,
        color = Color(0xFFB0BEC5),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally) // Centra horizontalmente
    )
}
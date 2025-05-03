package com.example.gicaappandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gicaappandroid.R
import com.example.gicaappandroid.ui.components.ImageCarousel
import com.example.gicaappandroid.ui.components.ImageCarouselWithReflection


@Composable
fun WelcomeScreen(navController: NavController) {
    val imageList = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    )

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
    ){
        Column {
            Spacer(Modifier.padding(10.dp))
            Text(
                text = "GICA",
                color = White,
                fontSize = 44.sp,
                lineHeight = 55.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
            )
            //ImageCarouselWithReflection(images = imageList)
            ImageCarousel(images = imageList)
            Box(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(),
                Alignment.BottomCenter
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .wrapContentSize()
                        .shadow(
                            elevation = 40.dp,
                            shape = RoundedCornerShape(30.dp), // Redondeado premium
                            clip = true
                        )
                        .background(
                            color = Color(0xFFf5821d ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { navController.navigate("authoptions") }
                        .padding(horizontal = 100.dp, vertical = 20.dp)
                ) {
                    Text(
                        text = "Comenzar",
                        color = White,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Ir",
                        tint = White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            ) {
                IconButton(onClick = { /* abrir Facebook */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Facebook",
                        tint = Color.Unspecified
                    )
                }

                IconButton(onClick = { /* abrir YouTube */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "YouTube",
                        tint = Color.Unspecified
                    )
                }

                IconButton(onClick = { /* abrir Instagram */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Instagram",
                        tint = Color.Unspecified
                    )
                }

                IconButton(onClick = { /* abrir Twitter/X */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Twitter/X",
                        tint = Color.Unspecified
                    )
                }
            }

            Text(
                text = "Visita nuestras redes sociales",
                fontSize = 12.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

package com.example.gicaappandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@Composable
fun ImageCarousel(images: List<Int>) {
    val pagerState = androidx.compose.foundation.pager.rememberPagerState(pageCount = {images.size})//Crea y recuerda el estado del pager. tamaño de la lista e imágenes
    //:Este estado nos permite controlar y observar cuál página está activa (currentPage) y navegar entre páginas (animateScrollToPage()).

    // Auto scroll
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        androidx.compose.foundation.pager.HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .height(500.dp)
        ) { page ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
                    .shadow(
                        elevation = 1.dp, // Altura de la sombra
                        shape = RoundedCornerShape(8.dp), // Misma forma que el border/background
                        clip = false // Importante para que el fondo no se recorte si no quieres
                    )
                    .border(
                        width = 1.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFFFF9800), Color(0xFF162365)) // Puedes usar los colores que quieras
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(
                        color = Color.Black.copy(alpha = 0.1f), // 10% opacidad
                        shape = RoundedCornerShape(8.dp)
                    )
            ){
                Text("Bienvenido a GicaAPP")
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Imagen $page",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .padding(10.dp)
                )
            }
        }

        //Indicadores manuales ( a futuro se agregará soorte oficial)
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(images.size) { index ->
                val isSelected = index == pagerState.currentPage
                Box(
                    modifier = Modifier
                        .size(if (isSelected) 10.dp else 6.dp)
                        .clip(RoundedCornerShape(50))
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                        )
                )
            }
        }
    }
}
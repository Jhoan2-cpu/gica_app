package com.example.gicaappandroid.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import androidx.compose.ui.res.painterResource

@Composable
fun CarouselCard(images: List<Int>) {
    val pagerState = androidx.compose.foundation.pager.rememberPagerState(pageCount = {images.size})//Crea y recuerda el estado del pager. tamaño de la lista e imágenes
    //:Este estado nos permite controlar y observar cuál página está activa (currentPage) y navegar entre páginas (animateScrollToPage()).

    // Auto scroll
    LaunchedEffect(Unit) {
        while (true) {
            delay(6000)
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        androidx.compose.foundation.pager.HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(2.dp, Color.Red)
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = "Imagen $page",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(2.dp, Color.Red)
            )
        }

        //Indicadores manuales ( a futuro se agregará soorte oficial)
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
                .border(2.dp, Color.Red),
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

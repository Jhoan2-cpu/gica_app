package com.example.gicaappandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gicaappandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeHeader(onMenuClick: () -> Unit = {}, scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar( // <-- CAMBIO aquí
        title = {
            Image(
                painter = painterResource(R.drawable.ic_gica_app_light),
                contentDescription = "Logo",
                modifier = Modifier.height(60.dp),
                contentScale = ContentScale.Fit
            )
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menú")
            }
        },
        scrollBehavior = scrollBehavior
    )

    /*
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFF4A3F3F), shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.logo_header),
                contentDescription = "Logo",
                modifier = Modifier.height(60.dp),
                contentScale = ContentScale.Fit
            )

            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
    */
}

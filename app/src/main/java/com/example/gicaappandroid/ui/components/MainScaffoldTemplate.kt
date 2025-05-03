package com.example.gicaappandroid.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffoldTemplate(
    selectedItem: String,
    drawerState: MutableState<Boolean>,
    onItemSelected: (String) -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior,
    listState: LazyListState = rememberLazyListState(),
    content: @Composable () -> Unit // Cambiado el tipo de contenido
) {
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeHeader(onMenuClick = { drawerState.value = true }, scrollBehavior)
        },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = selectedItem,
                onItemSelected = onItemSelected
            )
        }
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0D1B2A), // Azul oscuro
                            Color(0xFF1B263B), // Azul intermedio
                            Color(0xFF415A77)  // Azul más claro
                        )
                    )
                )
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item { content() } // Invoca el contenido correctamente
        }
    }
}
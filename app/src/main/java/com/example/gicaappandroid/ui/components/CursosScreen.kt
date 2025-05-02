package com.example.gicaappandroid.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gicaappandroid.R
import com.example.gicaappandroid.data.dummy.DummyPostProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CursosScreen(navController: NavController) {

    //PARA EL EFECTO DE HIDEN AL HACER SCROLL
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val listState = rememberLazyListState()

    val onItemSelected: (String) -> Unit = {}//el onItem selected es lo que pasará al dar click en un item
    val posts = DummyPostProvider.dummyPosts
    val drawerState = remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Inicio") }

    MainScaffoldTemplate(
        drawerState = drawerState,
        selectedItem = selectedItem,
        onItemSelected = onItemSelected,
        scrollBehavior = scrollBehavior,
        navController = navController // Se pasa el navController aquí
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF0D1B2A), // Azul oscuro
                                Color(0xFF1B263B), // Azul intermedio
                                Color(0xFF415A77)  // Azul más claro
                            )
                        )
                    )
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
                    val cursos = listOf("Curso de Kotlin", "Curso de Android", "Curso de UI/UX", "Curso de Backend")
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



    }


    // Drawer (menú lateral)
    AnimatedVisibility(
        visible = drawerState.value,
        enter = slideInHorizontally(initialOffsetX = { -it }),
        exit = slideOutHorizontally(targetOffsetX = { -it }),
    ) {
        SideMenu(
            onClose = { drawerState.value = false },
            selectedItem = "Mi perfil" // puedes manejarlo con estado también
        )
    }



}
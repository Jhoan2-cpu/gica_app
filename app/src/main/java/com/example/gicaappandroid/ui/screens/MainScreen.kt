package com.example.gicaappandroid.ui.screens


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.gicaappandroid.ui.components.MainScaffoldTemplate
import com.example.gicaappandroid.ui.screens.accountscreen.AccountScreen
import com.example.gicaappandroid.ui.screens.accountscreen.AccountUserScreen
import com.example.gicaappandroid.ui.screens.accountscreen.EditProfileScreen
import com.example.gicaappandroid.ui.screens.accountscreen.SettingsScreen
import com.example.gicaappandroid.ui.screens.regulations.RegulationsScreen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val listState = rememberLazyListState()
    val drawerState = remember { mutableStateOf(false) }
    var currentSection by remember { mutableStateOf("Inicio") } // Estado local para manejar la sección actual

    MainScaffoldTemplate(
        drawerState = drawerState,
        selectedItem = currentSection,
        onItemSelected = { selected ->
            currentSection = selected // Cambia la sección actual
        },
        scrollBehavior = scrollBehavior
    ) {
        AnimatedContent(
            targetState = currentSection,
            transitionSpec = {
                slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }) + fadeIn() with
                        slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth }) + fadeOut()
            }
        ) { targetSection ->
            when (targetSection) {
                "Inicio" -> HomeScreen()
                "Cursos" -> CoursesScreen()
                "Reglamentos" -> RegulationsScreen()
                "Plataformas" -> Text("Contenido de la sección Plataformas")
                "Usuario" -> AccountScreen()
            }
        }
    }
}
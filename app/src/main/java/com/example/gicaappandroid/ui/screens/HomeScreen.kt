package com.example.gicaappandroid.ui.screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.gicaappandroid.R
import com.example.gicaappandroid.data.dummy.DummyPostProvider
import com.example.gicaappandroid.data.model.Beneficio
import com.example.gicaappandroid.data.model.Categoria
import com.example.gicaappandroid.data.model.Testimonio
import com.example.gicaappandroid.ui.components.ImageCarousel
import com.example.gicaappandroid.ui.components.MainScaffoldTemplate
import com.example.gicaappandroid.ui.components.SideMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    //PARA EL EFECTO DE HIDEN AL HACER SCROLL
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val listState = rememberLazyListState()

    val posts = DummyPostProvider.dummyPosts
    val drawerState = remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Inicio") }
    val imageList = listOf(
        R.drawable.ic_gica_app_light,
        R.drawable.ic_gica_app_light,
        R.drawable.ic_gica_app_light
    )
    val categorias = listOf(
        Categoria("Geohidráulica", "Optimiza los sistemas hidráulicos y mejora el rendimiento en minería.", R.drawable.ic_launcher_background),
        Categoria("Maquinaria Pesada", "Conviértete en experto en maquinaria pesada y maximiza su rendimiento.", R.drawable.ic_launcher_background),
        Categoria("Mantenimiento", "Optimiza procesos y vida útil de máquinas industriales.", R.drawable.ic_launcher_background)
    )
    val beneficios = listOf(
        Beneficio(1, "Capacitación por competencia", "Nuestros programas académicos...", R.drawable.ic_launcher_background),
        Beneficio(2, "Especialistas en el área", "Nuestros docentes y tutores son...", R.drawable.ic_launcher_background),
        Beneficio(4, "Enseñanza personalizada", "Nuestros programas académicos se desarrollan en forma...", R.drawable.ic_launcher_background)
    )
    val testimonios = listOf<Testimonio>(
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        ),
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        ),
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        ),
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        ),
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        ),
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        ),
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        ),
        Testimonio(
            nombre = "Camila Paredes Quispe",
            mensaje = "La experiencia con Gica Ingenieros es inigualable...",
            fotoResId = R.drawable.ic_launcher_background // reemplaza con tu recurso real
        )
    )
    val onItemSelected: (String) -> Unit = {}//el onItem selected es lo que pasará al dar click en un item


    MainScaffoldTemplate(
        drawerState = drawerState,
        selectedItem = selectedItem,
        onItemSelected = onItemSelected,
        scrollBehavior = scrollBehavior,
        navController = navController // Se pasa el navController aquí
    ) {
        item {
            ImageCarousel(images = imageList)
        }

/*
*         item {
            CoursesSection(posts)
        }
        *
        *         item{

            CategoriasSection(categorias)
        }
        item {
            TestimoniosSection(testimonios)
        }
        item {
            BeneficiosSection(beneficios)
        }
        *
        *
* */
        item {
            Text("TODOS LOS COMPONENTES COMPOSABLES COMENTADOS EN LA PARTE DE ARRIBA, SON AGREGABLES")
            Text("TODOS LOS COMPONENTES COMPOSABLES COMENTADOS EN LA PARTE DE ARRIBA, SON AGREGABLES")
            Text("TODOS LOS COMPONENTES COMPOSABLES COMENTADOS EN LA PARTE DE ARRIBA, SON AGREGABLES")
            Text("TODOS LOS COMPONENTES COMPOSABLES COMENTADOS EN LA PARTE DE ARRIBA, SON AGREGABLES")
            Text("TODOS LOS COMPONENTES COMPOSABLES COMENTADOS EN LA PARTE DE ARRIBA, SON AGREGABLES")

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

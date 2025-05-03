package com.example.gicaappandroid.AppNavigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gicaappandroid.ui.screens.*
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = "welcome",
        enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn() },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut() },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) + fadeIn() },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) + fadeOut() }
    ) {
        composable("welcome") { WelcomeScreen(navController) }
        composable("authoptions") { AuthOptionsScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable ("main") { MainScreen() }
    }


/*        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen() }
        composable("welcome") { WelcomeScreen(navController) }
 */

}

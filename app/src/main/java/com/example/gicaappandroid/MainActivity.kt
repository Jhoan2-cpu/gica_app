package com.example.gicaappandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gicaappandroid.AppNavigation.AppNavigation
import com.example.gicaappandroid.ui.theme.GicaAppAndroidTheme
import com.example.gicaappandroid.ui.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel = AuthViewModel()
        viewModel.testLoginDirecto()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GicaAppAndroidTheme {
                GicaAppAndroidTheme {
                    AppNavigation()
                }
            }
        }
    }
}
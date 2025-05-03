package com.example.gicaappandroid.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gicaappandroid.data.model.WPLoginResponse
import com.example.gicaappandroid.data.network.LoginRequest
import com.example.gicaappandroid.data.network.WPAuthService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://1ee7-179-6-100-108.ngrok-free.app/") // ✅ tu nueva URL pública
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(WPAuthService::class.java)

    fun login(email: String, password: String, onResult: (Boolean, WPLoginResponse?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = service.login(LoginRequest(email, password))
                Log.v("Info RESPONSE", "$response")
                if (response.isSuccessful) {
                    onResult(true, response.body())
                } else {
                    onResult(false, null)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                onResult(false, null)
            }
        }
    }

    fun testLoginDirecto() {
        viewModelScope.launch {
            val pass = "b9drNXQ^WDA!TJ3nQH4DM3MT"
            val response = service.login(LoginRequest("echo", pass))
            if (response.isSuccessful) {
                Log.v("LOGIN_TEST", "✅ ${response.body()}")
            } else {
                Log.v("LOGIN_TEST", "❌ Código: ${response.code()}, Error: ${response.errorBody()?.string()}")
            }
        }
    }
}
package com.example.gicaappandroid.data.api
import com.example.gicaappandroid.utils.Resource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://1ee7-179-6-100-108.ngrok-free.app"

    val api: WordPressApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WordPressApi::class.java)
    }

    fun login(username: String, password: String): Resource<String> {
        // Simulación de una llamada a la API
        return if (username == "admin" && password == "1234") {
            Resource.Success("TokenDeAutenticacion")
        } else {
            Resource.Error("Credenciales incorrectas")
        }
    }
}
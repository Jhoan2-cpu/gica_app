package com.example.gicaappandroid.data.repository

import com.example.gicaappandroid.data.api.ApiClient
import com.example.gicaappandroid.data.model.LoginRequest
import com.example.gicaappandroid.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository {
    suspend fun login(username: String, password: String): Resource<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = ApiClient.api.login(LoginRequest(username, password))
                Resource.Success(response.token)
            } catch (e: Exception) {
                Resource.Error(e.message ?: "Error desconocido")
            }
        }
    }
}
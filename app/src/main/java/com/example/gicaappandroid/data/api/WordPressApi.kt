package com.example.gicaappandroid.data.api

import com.example.gicaappandroid.data.model.LoginRequest
import com.example.gicaappandroid.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface WordPressApi {
    @POST("wp-json/jwt-auth/v1/token")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}
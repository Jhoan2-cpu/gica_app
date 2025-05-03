package com.example.gicaappandroid.data.network

import com.example.gicaappandroid.data.model.WPLoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class LoginRequest(val username: String, val password: String)

interface WPAuthService {
    @Headers("Content-Type: application/json")
    @POST("wp-json/gica/v1/login")
    suspend fun login(@Body request: LoginRequest): Response<WPLoginResponse>
}
package com.example.gicaappandroid.data.model

data class LoginResponse(
    val token: String,
    val user_email: String,
    val user_nicename: String,
    val user_display_name: String
)
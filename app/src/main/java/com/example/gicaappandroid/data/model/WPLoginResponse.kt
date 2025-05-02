package com.example.gicaappandroid.data.model

data class WPLoginResponse(
    val success: Boolean,
    val message: String,
    val user: WPUser?
)
package com.example.gicaappandroid.data.model

data class Post(
    val id: Int,
    val title: Rendered,
    val excerpt: Rendered
)

data class Rendered(
    val rendered: String
)
package com.cha1se.domain.model

data class CatBreed(
    val temperament: String,
    val id: String,
    val name: String,
    val description: String,
    val image: Image
)

data class Image(
    val id: String,
    val url: String
)
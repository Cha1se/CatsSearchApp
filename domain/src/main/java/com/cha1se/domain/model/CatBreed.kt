package com.cha1se.domain.model

data class CatBreed(
    val weight: Weight,
    val id: String,
    val name: String,
    val description: String,
    val image: Image
)

data class Weight(
    val imperial: String,
    val metric: String
)

data class Image(
    val id: String,
    val url: String
)
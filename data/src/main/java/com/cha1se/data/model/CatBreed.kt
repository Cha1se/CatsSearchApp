package com.cha1se.data.model

import com.cha1se.domain.model.CatBreed

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

fun com.cha1se.domain.model.CatBreed.toData() = com.cha1se.data.model.CatBreed(
    weight = this.weight.toData(),
    id = this.id,
    name = this.name,
    description = this.description,
    image = this.image.toData(),
)

fun com.cha1se.domain.model.Weight.toData() = com.cha1se.data.model.Weight(
    imperial = this.imperial,
    metric = this.metric,
)

fun com.cha1se.domain.model.Image.toData() = com.cha1se.data.model.Image(
    id = this.id,
    url = this.url,
)

fun com.cha1se.data.model.CatBreed.toDomain() = com.cha1se.domain.model.CatBreed(
    weight = this.weight.toDomain(),
    id = this.id,
    name = this.name,
    description = this.description,
    image = this.image.toDomain(),
)

fun com.cha1se.data.model.Weight.toDomain() = com.cha1se.domain.model.Weight(
    imperial = this.imperial,
    metric = this.metric,
)

fun com.cha1se.data.model.Image.toDomain() = com.cha1se.domain.model.Image(
    id = this.id,
    url = this.url,
)
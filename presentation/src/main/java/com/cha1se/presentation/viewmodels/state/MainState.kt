package com.cha1se.presentation.viewmodels.state

import com.cha1se.domain.model.CatBreed

data class MainState (
    val catList: List<CatBreed> = emptyList()
)
package com.cha1se.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.model.Image

@Preview
@Composable
fun AboutScreen(navController: NavController = rememberNavController(), id: String? = "") {
    val data = CatBreed(
        id = "0",
        name = "Barsik",
        description = "My name is Barsik, i like a fish",
        image = Image(id = "0", url = "https://cdn2.thecatapi.com/images/3kh.jpg"),
        temperament = "Dobriy dobriy cat"
    )

    
}
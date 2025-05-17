package com.cha1se.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.cha1se.presentation.navigation.Navigation
import com.cha1se.presentation.theme.Background

import com.cha1se.presentation.theme.CatsSearchAppTheme
import com.cha1se.presentation.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navHostController = rememberNavController()

            CatsSearchAppTheme {
                Scaffold(Modifier.fillMaxSize(), containerColor = Background) {
                    Navigation(navHostController)
                }
            }
        }
    }
}
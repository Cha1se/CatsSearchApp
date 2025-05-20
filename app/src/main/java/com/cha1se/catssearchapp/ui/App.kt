package com.cha1se.catssearchapp.ui

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.cha1se.data.BASE_URL
import com.cha1se.data.CatApi
import com.cha1se.data.RepositoryImpl
import com.cha1se.domain.repository.Repository
import com.cha1se.presentation.viewmodels.MainViewModel
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class App() : Application()
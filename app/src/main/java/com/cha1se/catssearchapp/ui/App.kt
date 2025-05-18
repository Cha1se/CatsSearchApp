package com.cha1se.catssearchapp.ui

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.cha1se.data.BASE_URL
import com.cha1se.data.CatApi
import com.cha1se.data.RepositoryImpl
import com.cha1se.domain.repository.Repository
import com.cha1se.presentation.viewmodels.MainViewModel
import com.cha1se.presentation.viewmodels.ProvideMainViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App() : Application(), ProvideMainViewModel {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val repository: Repository = RepositoryImpl(
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(
            CatApi::class.java))
        mainViewModel = MainViewModel(repository)
    }

    override fun viewModel(): MainViewModel {
        return mainViewModel
    }


}
package com.cha1se.catssearchapp.ui.di

import com.cha1se.data.BASE_URL
import com.cha1se.data.CatApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideApi(@DebugRetrofit retrofit: Retrofit): CatApi = retrofit.create(CatApi::class.java)

    @DebugRetrofit
    @Singleton
    @Provides
    fun provideDebugRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    @ReleaseRetrofit
    @Singleton
    @Provides
    fun provideReleaseRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl("https://google.com/").addConverterFactory(GsonConverterFactory.create()).build()


}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DebugRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ReleaseRetrofit
package com.cha1se.catssearchapp.ui.di

import com.cha1se.data.RepositoryImpl
import com.cha1se.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PresentationModule {

    @Binds
    abstract fun provideRepository(repo: RepositoryImpl): Repository
}
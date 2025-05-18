package com.cha1se.domain.repository

import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun loadCats(query: String = " ", limit: Int, page: Int): Flow<Result<List<CatBreed>>>

}




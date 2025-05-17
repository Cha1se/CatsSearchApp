package com.cha1se.domain.repository

import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.util.Result

interface Repository {

    suspend fun loadCats(limit: Int, page: Int): Result<List<CatBreed>>

}




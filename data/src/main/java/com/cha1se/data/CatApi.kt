package com.cha1se.data

import com.cha1se.data.model.CatBreed
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatApi {

    @GET("breeds/")
    suspend fun getBreeds(
        @Header("Authorization") token: String = "Bearer $MY_TOKEN",
        @Query("limit") limit: Int,
        @Query("page") page: Int,
    ): List<CatBreed>

}
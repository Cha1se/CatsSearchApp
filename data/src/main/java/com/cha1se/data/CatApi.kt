package com.cha1se.data

import com.cha1se.data.model.CatBreed
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatApi {

    @GET("breeds/search")
    suspend fun getBreeds(
        @Header("x-api-key") token: String = MY_TOKEN,
        @Query("attach_image") attachImage: Int = 1,
        @Query("q") query: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int,
    ): List<CatBreed>

}
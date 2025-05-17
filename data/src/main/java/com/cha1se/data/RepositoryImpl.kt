package com.cha1se.data

import com.cha1se.data.model.toDomain
import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.repository.Repository
import com.cha1se.domain.util.Result
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.thecatapi.com/v1/"

class RepositoryImpl(private val api: CatApi): Repository {

    constructor() : this(
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(CatApi::class.java)
    )

    override suspend fun loadCats(limit: Int, page: Int): Result<List<CatBreed>> {
        return try {
            Result.success(api.getBreeds(limit = limit, page = page).map { it.toDomain() })
        } catch (exception: HttpException) {
            Result.error(exception)
        } catch (exception: Exception) {
            Result.error(exception)
        }
    }
}
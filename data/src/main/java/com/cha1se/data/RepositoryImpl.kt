package com.cha1se.data

import com.cha1se.data.model.toDomain
import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.repository.Repository
import com.cha1se.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

const val BASE_URL = "https://api.thecatapi.com/v1/"

class RepositoryImpl @Inject constructor(private val api: CatApi): Repository {

    override suspend fun loadCats(query: String, limit: Int, page: Int): Flow<Result<List<CatBreed>>> = flow {
        emit(Result.Loading)
        emit(
            api.getBreeds(query = query, limit = limit, page = page).map { it.toDomain() }.safeRequest()
        )
    }
}

fun <T> T.safeRequest(): Result<T> {
    return try {
        Result.success(this)
    } catch (exception: HttpException) {
        Result.error(exception)
    } catch (exception: Exception) {
        Result.error(exception)
    }
}
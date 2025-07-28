package com.cha1se.domain.repository

import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.model.Image
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class RepositoryTest {

    val repositoryTest = mock<Repository>()

    @Test
    fun `is all cats loaded`() = runTest {
        Mockito.`when`(repositoryTest.loadCats(limit = 1, page = 1)).thenReturn(
            flowOf(
                com.cha1se.domain.util.Result.success(
                    listOf(
                        CatBreed(
                            temperament = "Intelligent, Interactive, Lively, Playful, Sensitive",
                            id = "abob",
                            name = "American Bobtail",
                            description = "American Bobtails are loving and incredibly intelligent cats possessing a distinctive wild appearance. They are extremely interactive cats that bond with their human family with great devotion.",
                            image = Image(
                                id = "hBXicehMA",
                                url = "https://cdn2.thecatapi.com/images/hBXicehMA.jpg"
                            )
                        )
                    )
                )
            )
        )
        var result = listOf<CatBreed>()
        repositoryTest.loadCats(limit = 1, page = 1).collect { if (it is com.cha1se.domain.util.Result.Success) result = it.data }

        assertEquals(result, listOf(
            CatBreed(
                temperament = "Intelligent, Interactive, Lively, Playful, Sensitive",
                id = "abob",
                name = "American Bobtail",
                description = "American Bobtails are loving and incredibly intelligent cats possessing a distinctive wild appearance. They are extremely interactive cats that bond with their human family with great devotion.",
                image = Image(
                    id = "hBXicehMA",
                    url = "https://cdn2.thecatapi.com/images/hBXicehMA.jpg"
                )
            )
        ))
    }
}


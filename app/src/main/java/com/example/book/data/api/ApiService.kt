package com.example.book.data.api

import com.example.book.domain.models.BookList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/books/v1/volumes")
    suspend fun getBooks(
    @Query("q") text: String
    ): Response<BookList>
}
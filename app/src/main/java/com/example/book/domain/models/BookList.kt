package com.example.book.domain.models

data class BookList(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)
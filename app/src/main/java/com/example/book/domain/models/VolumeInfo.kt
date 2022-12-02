package com.example.book.domain.models

data class VolumeInfo(
    val authors: List<String>,
    val imageLinks: ImageLinks,
    val publishedDate: String,
    val title: String,
    val subTitle: String

)
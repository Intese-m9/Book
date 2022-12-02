package com.example.book.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IntentBook(
    val image: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val publish: String,
) : Parcelable
package com.example.book.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.book.R
import com.example.book.domain.models.IntentBook
import kotlinx.android.synthetic.main.activity_details_book.*

class DetailsBook : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_book)
        val documentInfo: IntentBook = intent.getParcelableExtra<Parcelable>("bookInfo") as IntentBook
        val urlImage:String = documentInfo.image
        val titleIntent:String = documentInfo.title
        val authorIntent:String = documentInfo.author
        val descIntent:String = documentInfo.subtitle
        val pubDateIntent:String = documentInfo.publish
        Glide.with(this).load(urlImage).centerCrop().into(imageBook)
        tvTitle.text = (titleIntent)
        tvAuthor.text = ("Автор: $authorIntent")
        tvDesc.text = ("Описание: $descIntent")
        tvPublish.text = ("Дата публикации: $pubDateIntent")
    }
}
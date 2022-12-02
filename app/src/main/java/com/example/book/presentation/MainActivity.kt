package com.example.book.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.book.R
import com.example.book.domain.adapter.BooksListAdapter
import com.example.book.domain.checkerror.NetworkResult
import com.example.book.presentation.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter = BooksListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.bookList.observe(this){ list ->

            list.body()?.let {adapter.setList(it.items)}
        }
        viewModel.userResponseLiveData.observe(this) {
            progressBar.isVisible = false
            when (it) {
                is NetworkResult.Success -> {
                    Toast.makeText(applicationContext, "Данные загружены", Toast.LENGTH_SHORT)
                        .show()
                }
                is NetworkResult.Error -> {
                    Toast.makeText(applicationContext, "Возникла ошибка!", Toast.LENGTH_SHORT)
                        .show()

                }
                is NetworkResult.Loading -> {
                    progressBar.isVisible = true

                }

            }
        }
        rv_book.adapter = adapter
        searchButton.setOnClickListener {
            viewModel.getBooks(search.text.toString())
        }


    }
}
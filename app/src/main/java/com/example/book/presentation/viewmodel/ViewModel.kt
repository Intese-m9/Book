package com.example.book.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book.data.repository.Repository
import com.example.book.domain.checkerror.NetworkResult
import com.example.book.domain.models.BookList
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel: ViewModel() {
    val repository by lazy { Repository() }
    val userResponseLiveData : LiveData<NetworkResult<BookList>>
    get() = repository.userRepsonseLiveData
    var bookList: MutableLiveData<Response<BookList>> = MutableLiveData()

    fun getBooks(text: String){
        viewModelScope.launch {
            bookList.value = repository.getBooks(text)
        }

    }

}
package com.example.book.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.book.data.api.RetrofitHelper
import com.example.book.domain.checkerror.NetworkResult
import com.example.book.domain.models.BookList
import retrofit2.Response

class Repository {
    private val _userResponseLiveData = MutableLiveData<NetworkResult<BookList>>()
     val userRepsonseLiveData: LiveData<NetworkResult<BookList>>
        get() = _userResponseLiveData

    suspend fun getBooks(text: String): Response<BookList>{
        _userResponseLiveData.postValue(NetworkResult.Loading())
        val response = RetrofitHelper.api.getBooks(text)
        when {
            response.isSuccessful && response.body() != null -> {
                _userResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
            }
            response.errorBody() != null -> {
                _userResponseLiveData.postValue(NetworkResult.Error("Ошибка"))

            }
            else -> {
                _userResponseLiveData.postValue(NetworkResult.Error("Ошибка"))
            }
        }
        return RetrofitHelper.api.getBooks(text)
    }
}
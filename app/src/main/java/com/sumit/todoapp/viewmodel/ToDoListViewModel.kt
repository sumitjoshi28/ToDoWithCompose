package com.sumit.todoapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.sumit.todoapp.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class ToDoListViewModel(private val toDoRepository: ToDoRepository) :ViewModel() {

    init {
        getToDosFromApi()
    }
    private fun getToDosFromApi(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    val response = toDoRepository.getToDosFromApi()
                    if (response.isSuccessful){
                        // Process state to update UI
                        Log.d("response", "response: ${Gson().toJson(response.body())}")
                    }else{
                        // TODO: Handle Error
                    }
                }catch (httpException:HttpException){
                    Log.d("httpException", "getToDosFromApi: $httpException")
                }
            }
        }
    }
}
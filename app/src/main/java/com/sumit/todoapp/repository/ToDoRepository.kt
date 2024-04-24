package com.sumit.todoapp.repository

import com.sumit.todoapp.api.remote.ApiService

class ToDoRepository(private val apiService: ApiService) {
    suspend fun getToDosFromApi() = apiService.getTodosFromApi()
}
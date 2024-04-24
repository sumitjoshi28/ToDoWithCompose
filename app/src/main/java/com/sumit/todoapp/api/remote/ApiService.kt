package com.sumit.todoapp.api.remote

import com.sumit.todoapp.api.model.response.ToDoResponse
import com.sumit.todoapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET(Constants.TODO_LIST)
    suspend fun getTodosFromApi(): Response<ToDoResponse>
}
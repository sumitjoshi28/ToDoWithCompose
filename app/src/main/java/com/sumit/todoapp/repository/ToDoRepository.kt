package com.sumit.todoapp.repository

import com.sumit.todoapp.api.model.response.ToDoResponseItem
import com.sumit.todoapp.api.remote.ApiService
import com.sumit.todoapp.db.LocalDb

class ToDoRepository(private val apiService: ApiService,
                     private val localDb: LocalDb) {
    // Data from the server.
    suspend fun getToDosFromApi() = apiService.getTodosFromApi()

    // Data from local db.
    suspend fun getToDoList():List<ToDoResponseItem>{
        return localDb.toDoListDao().getToDoList()
    }
    suspend fun saveToDo(toDoResponseItem: ToDoResponseItem) {
        return localDb.toDoListDao().saveToDoList(toDoResponseItem)
    }
}
package com.sumit.todoapp.api.model.response

class ToDoResponse : ArrayList<ToDoResponseItem>()

data class ToDoResponseItem(
    val completed: Boolean? = false,
    val id: Int? = -1,
    val title: String? = "",
    val userId: Int? = -1
)
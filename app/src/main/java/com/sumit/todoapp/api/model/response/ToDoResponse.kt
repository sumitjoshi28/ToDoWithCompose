package com.sumit.todoapp.api.model.response

import androidx.room.Entity
import androidx.room.PrimaryKey

class ToDoResponse : ArrayList<ToDoResponseItem>()

@Entity(tableName = "to_do_list")
data class ToDoResponseItem(
    val completed: Boolean? = false,
    val id: Int? = -1,
    val title: String? = "",
    val userId: Int? = -1,
    @PrimaryKey(autoGenerate = true) var autoId: Int = 0
)
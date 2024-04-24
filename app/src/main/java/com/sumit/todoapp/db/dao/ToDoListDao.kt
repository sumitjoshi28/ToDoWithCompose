package com.sumit.todoapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sumit.todoapp.api.model.response.ToDoResponseItem

@Dao
interface ToDoListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToDoList(toDoResponseItem: ToDoResponseItem)

    @Query("SELECT * FROM to_do_list")
    suspend fun getToDoList(): List<ToDoResponseItem>
}
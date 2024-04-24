package com.sumit.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sumit.todoapp.api.model.response.ToDoResponseItem
import com.sumit.todoapp.db.dao.ToDoListDao

@Database(entities = [ToDoResponseItem::class], version = 1, exportSchema = false)
abstract class LocalDb : RoomDatabase() {
    companion object{
        fun setupChargerDatabase(appContext: Context): LocalDb {
            return Room.databaseBuilder(appContext, LocalDb::class.java, "to_do_app_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    abstract fun toDoListDao(): ToDoListDao
}
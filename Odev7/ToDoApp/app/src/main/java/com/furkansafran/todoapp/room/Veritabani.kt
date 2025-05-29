package com.furkansafran.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.furkansafran.todoapp.data.entity.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getToDosDao() : ToDosDao

}
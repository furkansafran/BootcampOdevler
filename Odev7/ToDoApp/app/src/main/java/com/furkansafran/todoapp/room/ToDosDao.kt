package com.furkansafran.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.furkansafran.todoapp.data.entity.ToDos

@Dao
interface ToDosDao {
    @Query("SELECT * FROM toDos")
    suspend fun toDosYukle() : List<ToDos>
    @Insert
    suspend fun toDoKaydet(toDo: ToDos)
    @Update
    suspend fun toDoGuncelle(toDo: ToDos)
    @Delete
    suspend fun toDoSil(toDo: ToDos)
    @Query("SELECT * FROM toDos WHERE name like '%' || :aramaKelimesi || '%'")
    suspend fun toDoArama(aramaKelimesi:String) : List<ToDos>



}
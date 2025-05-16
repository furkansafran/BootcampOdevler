package com.furkansafran.todoapp.data.entity.repository

import com.furkansafran.todoapp.data.entity.ToDos
import com.furkansafran.todoapp.data.entity.datasource.ToDosDataSource

class ToDosRepository(var ds: ToDosDataSource) {
    suspend fun toDosKaydet(name: String) = ds.toDosKaydet(name)
    suspend fun toDosGuncelle(id: Int, name: String) = ds.toDosGuncelle(id, name)
    suspend fun toDosSil(id:Int) = ds.toDosSil(id)
    suspend fun toDosYukle() : List<ToDos> = ds.toDosYukle()
    suspend fun toDosAra(aramaKelimesi:String) : List<ToDos> = ds.toDosAra(aramaKelimesi)
}
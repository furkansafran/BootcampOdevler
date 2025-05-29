package com.furkansafran.todoapp.data.entity.datasource

import com.furkansafran.todoapp.data.entity.ToDos
import com.furkansafran.todoapp.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {
    suspend fun toDosKaydet(name: String){
        val yeniToDos = ToDos(0,name)
        toDosDao.toDoKaydet(yeniToDos)
    }
    suspend fun toDosGuncelle(id: Int, name: String){
        val guncellenenToDos = ToDos(id,name)
        toDosDao.toDoGuncelle(guncellenenToDos)
    }

    suspend fun toDosSil(id:Int){
        val silinenToDos = ToDos(id,"")
        toDosDao.toDoSil(silinenToDos)
    }
    suspend fun toDosYukle() : List<ToDos> = withContext(Dispatchers.IO){
    return@withContext toDosDao.toDosYukle()
    }
    suspend fun toDosAra(aramaKelimesi:String) : List<ToDos> = withContext(Dispatchers.IO){
        return@withContext toDosDao.toDoArama(aramaKelimesi)
    }



}

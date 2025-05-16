package com.furkansafran.todoapp.ui.fragments.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.furkansafran.todoapp.data.entity.ToDos
import com.furkansafran.todoapp.data.entity.repository.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel@Inject constructor(var toDosRepository: ToDosRepository) :ViewModel() {
    var toDosListesi = MutableLiveData<List<ToDos>>()

init {
    toDosYukle()
}
    fun toDosSil(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.toDosSil(id)
            toDosYukle()
        }

    }

    fun toDosYukle(){
    CoroutineScope(Dispatchers.Main).launch {
        toDosListesi.value = toDosRepository.toDosYukle()
    }
    }
    fun toDosAra(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosListesi.value = toDosRepository.toDosAra(aramaKelimesi)
        }
    }
}
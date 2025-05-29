package com.furkansafran.todoapp.ui.fragments.viewmodel

import androidx.lifecycle.ViewModel
import com.furkansafran.todoapp.data.entity.repository.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetayViewModel@Inject constructor(var toDosRepository: ToDosRepository) : ViewModel() {

    fun toDosGuncelle(id: Int, name: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.toDosGuncelle(id,name)
        }

    }

}
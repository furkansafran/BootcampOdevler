package com.furkansafran.yemekuygulamasi.ui.fragments.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkansafran.yemekuygulamasi.data.model.Yemekler
import com.furkansafran.yemekuygulamasi.data.model.repository.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(private val yemeklerRepository: YemeklerRepository) : ViewModel() {
    val yemekListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
    }

    fun yemekleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            yemekListesi.value  = yemeklerRepository.yemekleriYukle()

        }
    }
}

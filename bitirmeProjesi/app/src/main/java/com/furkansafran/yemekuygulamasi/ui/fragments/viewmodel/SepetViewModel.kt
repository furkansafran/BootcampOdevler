package com.furkansafran.yemekuygulamasi.ui.fragments.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.furkansafran.yemekuygulamasi.data.model.SepetYemekler
import com.furkansafran.yemekuygulamasi.data.model.Yemekler
import com.furkansafran.yemekuygulamasi.data.model.repository.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(var yemeklerRepository: YemeklerRepository) : ViewModel() {
    val yemekListesi = MutableLiveData<List<SepetYemekler>>()
    init {
        sepettekiYemekleriYukle("furkan_safran")
    }
    fun sepettekiYemekleriYukle(kullaniciAdi: String) {
        CoroutineScope(Dispatchers.Main).launch {
           yemekListesi.value = yemeklerRepository.sepetYemekleriYukle(kullaniciAdi).ifEmpty {
               emptyList()
           }
        }
    }

    fun sepettenYemekSil(sepetYemekId: Int, kullaniciAdi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yemeklerRepository.sepettenYemekSil(sepetYemekId, kullaniciAdi)
            sepettekiYemekleriYukle(kullaniciAdi)

        }

    }
}
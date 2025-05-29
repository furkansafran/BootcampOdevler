package com.furkansafran.yemekuygulamasi.ui.fragments.viewmodel

import androidx.lifecycle.ViewModel
import com.furkansafran.yemekuygulamasi.data.model.repository.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UrunDetayViewModel@Inject constructor(var yemeklerRepository: YemeklerRepository) : ViewModel() {
    fun sepeteYemekEkle(yemekAd: String, yemekResimAd: String, yemekFiyat: Int, yemekSiparisAdet: Int, kullaniciAdi: String) {
        CoroutineScope(Dispatchers.Main).launch{
            yemeklerRepository.sepeteYemekEkle(yemekAd, yemekResimAd, yemekFiyat, yemekSiparisAdet, kullaniciAdi)
        }


    }
}
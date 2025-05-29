package com.furkansafran.yemekuygulamasi.data.model.datasource

import android.util.Log
import com.furkansafran.yemekuygulamasi.data.model.SepetYemekler
import com.furkansafran.yemekuygulamasi.data.model.Yemekler
import com.furkansafran.yemekuygulamasi.retrofit.YemeklerDaoInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(private val yemeklerDaoInterface: YemeklerDaoInterface) {

    suspend fun yemekleriYukle(): List<Yemekler> = withContext(Dispatchers.IO) {
        return@withContext yemeklerDaoInterface.tumYemekler().yemekler
    }
    suspend fun sepetYemekleriYukle(kullaniciAdi: String): List<SepetYemekler> = withContext(Dispatchers.IO) {
        return@withContext yemeklerDaoInterface.sepettekiYemekler(kullaniciAdi).sepetYemekler
    }

    suspend fun sepeteYemekEkle(yemekAd: String, yemekResimAd: String, yemekFiyat: Int, yemekSiparisAdet: Int, kullaniciAdi: String) {
        val crudCevap = yemeklerDaoInterface.sepetteYemekEkle(yemekAd, yemekResimAd, yemekFiyat, yemekSiparisAdet, kullaniciAdi)
        Log.e("sepete yemek ekle", "Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }

    suspend fun sepettenYemekSil(sepetYemekId: Int, kullaniciAdi: String) {
        val crudCevap = yemeklerDaoInterface.sepettenYemekSil(sepetYemekId, kullaniciAdi)
        Log.e("sepetten yemek sil", "Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }
}
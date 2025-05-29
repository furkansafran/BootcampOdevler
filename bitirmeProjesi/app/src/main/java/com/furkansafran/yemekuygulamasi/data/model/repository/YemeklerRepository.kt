package com.furkansafran.yemekuygulamasi.data.model.repository

import com.furkansafran.yemekuygulamasi.data.model.SepetYemekler
import com.furkansafran.yemekuygulamasi.data.model.Yemekler
import com.furkansafran.yemekuygulamasi.data.model.datasource.YemeklerDataSource

class YemeklerRepository(var yemeklerDataSource: YemeklerDataSource) {
    suspend fun yemekleriYukle() : List<Yemekler> = yemeklerDataSource.yemekleriYukle()
    suspend fun sepetYemekleriYukle(kullaniciAdi: String) : List<SepetYemekler> = yemeklerDataSource.sepetYemekleriYukle(kullaniciAdi)
    suspend fun sepettenYemekSil(sepetYemekId: Int, kullaniciAdi: String) = yemeklerDataSource.sepettenYemekSil(sepetYemekId, kullaniciAdi)
    suspend fun sepeteYemekEkle(
        yemekAd: String, yemekResimAd: String, yemekFiyat: Int, yemekSiparisAdet: Int, kullaniciAdi: String)
    = yemeklerDataSource.sepeteYemekEkle(
        yemekAd, yemekResimAd, yemekFiyat, yemekSiparisAdet, kullaniciAdi)

}
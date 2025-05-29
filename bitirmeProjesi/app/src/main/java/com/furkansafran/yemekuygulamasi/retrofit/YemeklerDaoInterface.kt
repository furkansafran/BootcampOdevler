package com.furkansafran.yemekuygulamasi.retrofit

import com.furkansafran.yemekuygulamasi.data.model.CRUDCevap
import com.furkansafran.yemekuygulamasi.data.model.SepetYemeklerCevap
import com.furkansafran.yemekuygulamasi.data.model.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDaoInterface {
    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sepettenYemekSil(
        @Field("sepet_yemek_id") sepetYemekId: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): CRUDCevap
    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepetteYemekEkle(
        @Field("yemek_adi") yemekAd: String,
        @Field("yemek_resim_adi") yemekResimAd: String,
        @Field("yemek_fiyat") yemekFiyat: Int,
        @Field("yemek_siparis_adet") yemekSiparisAdet: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): CRUDCevap

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun tumYemekler(): YemeklerCevap
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun sepettekiYemekler(
        @Field("kullanici_adi") kullaniciAdi: String
    ): SepetYemeklerCevap




}
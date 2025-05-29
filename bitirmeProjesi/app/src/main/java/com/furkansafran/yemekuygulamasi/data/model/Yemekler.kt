package com.furkansafran.yemekuygulamasi.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Yemekler(
    @SerializedName("yemek_id")
    @Expose
    var yemekId: Int,
    @SerializedName("yemek_adi")
    @Expose
    var yemekAd: String,
    @SerializedName("yemek_resim_adi")
    @Expose
    var yemekResimAd: String,
    @SerializedName("yemek_fiyat")
    @Expose
    var yemekFiyat: Int
) : Serializable
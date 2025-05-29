package com.furkansafran.yemekuygulamasi.ui.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.furkansafran.yemekuygulamasi.data.model.SepetYemekler
import com.furkansafran.yemekuygulamasi.databinding.SepetCardTasarimBinding
import com.furkansafran.yemekuygulamasi.ui.fragments.viewmodel.SepetViewModel

class SepetAdapter(var mContext: Context, var sepetYemeklerListesi: List<SepetYemekler>,var viewModel: SepetViewModel):
    RecyclerView.Adapter<SepetAdapter.SepetCardTasarimTutucu>() {
    inner class SepetCardTasarimTutucu(val binding: SepetCardTasarimBinding):RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {
       val tasarim = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return SepetCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
        val sepetYemek = sepetYemeklerListesi.get(position)
        holder.binding.imageViewSepettenSil.setOnClickListener {
            viewModel.sepettenYemekSil(sepetYemek.sepetYemekId,"furkan_safran")
        }
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepetYemek.yemekResimAd}"
        Glide.with(mContext).load(url).override(150,150).into(holder.binding.imageViewSepet)
        holder.binding.textViewSepetYemekAd.text = sepetYemek.yemekAd
        holder.binding.textViewSepetYemekFiyat.text = "${sepetYemek.yemekFiyat} ₺"
        holder.binding.textViewSepetYemekAdet.text = "Adet: ${sepetYemek.yemekSiparisAdet}"
        holder.binding.textViewSepetToplamTutar.text = "Toplam: ${sepetYemek.yemekFiyat * sepetYemek.yemekSiparisAdet} ₺"


    }

    override fun getItemCount(): Int {
        return sepetYemeklerListesi.size
    }



}
package com.furkansafran.yemekuygulamasi.ui.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.furkansafran.yemekuygulamasi.data.model.Yemekler
import com.furkansafran.yemekuygulamasi.databinding.AnasayfaCardTasarimBinding
import com.furkansafran.yemekuygulamasi.ui.fragments.AnasayfaFragmentDirections

class YemeklerAdapter(
    private val context: Context,
    private val yemekListesi: List<Yemekler>
) : RecyclerView.Adapter<YemeklerAdapter.YemeklerCardTasarimTutucu>() {

    inner class YemeklerCardTasarimTutucu(val binding: AnasayfaCardTasarimBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemeklerCardTasarimTutucu {
        val tasarim = AnasayfaCardTasarimBinding.inflate(LayoutInflater.from(context), parent, false)
        return YemeklerCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: YemeklerCardTasarimTutucu, position: Int) {
        val yemek = yemekListesi.get(position)
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemekResimAd}"
        
        Glide.with(context)
            .load(url)
            .override(350,350)
            .into(holder.binding.imageViewYemek)

        holder.binding.textViewYemekAd.text = yemek.yemekAd
        holder.binding.textViewYemekFiyat.text = "${yemek.yemekFiyat} ₺"
        holder.binding.cvAnasayfa.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaTourunDetay(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }
}
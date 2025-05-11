package com.furkansafran.gamepasstasarim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.furkansafran.gamepasstasarim.Kategori
import com.furkansafran.gamepasstasarim.R

class RvCategoryAdapter(var mContext : Context, var kategoriListesi : ArrayList<Kategori>):
    RecyclerView.Adapter<RvCategoryAdapter.RvCategoryTasarimTutucu>() {
    inner class RvCategoryTasarimTutucu(tasarim : View): RecyclerView.ViewHolder(tasarim){
        val textViewCategoryName = tasarim.findViewById<TextView>(R.id.textViewCategoryName)
        val ivCategoryPhoto = tasarim.findViewById<ImageView>(R.id.ivCategoryPhoto)
        val cardView = tasarim.findViewById<CardView>(R.id.cv)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvCategoryTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.activity_main_category,parent,false)
        return RvCategoryTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: RvCategoryTasarimTutucu, position: Int) {
        val kategori = kategoriListesi.get(position)
        holder.textViewCategoryName.text = kategori.kategoriAdi
        holder.ivCategoryPhoto.setImageResource(kategori.icon)
        if (position < 2){
            holder.cardView.setCardBackgroundColor(mContext.resources.getColor(R.color.ilkRenk))
        }else if (position < 4){
            holder.cardView.setCardBackgroundColor(mContext.resources.getColor(R.color.ikinciRenk))
        }else if (position < 6){
            holder.cardView.setCardBackgroundColor(mContext.resources.getColor(R.color.ucuncuRenk))
        }else{
            holder.cardView.setCardBackgroundColor(mContext.resources.getColor(R.color.dorduncuRenk))
        }

    }

    override fun getItemCount(): Int {
       return kategoriListesi.size
    }


}

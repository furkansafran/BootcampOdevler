package com.furkansafran.gamepasstasarim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.furkansafran.gamepasstasarim.R

class RvResimAdapter(val mContext: Context,val resimListesi : List<Int>) : RecyclerView.Adapter<RvResimAdapter.RvResimAdapterTasarimTutucu>() {

    inner class RvResimAdapterTasarimTutucu(tasarim : View) : RecyclerView.ViewHolder(tasarim){
        val ivResim : ImageView = tasarim.findViewById(R.id.ivResim)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvResimAdapterTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.activity_main_photo,parent,false)
        return RvResimAdapterTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: RvResimAdapterTasarimTutucu, position: Int) {
      holder.ivResim.setImageResource(resimListesi[position])
    }

    override fun getItemCount(): Int {
        return resimListesi.size
    }


}
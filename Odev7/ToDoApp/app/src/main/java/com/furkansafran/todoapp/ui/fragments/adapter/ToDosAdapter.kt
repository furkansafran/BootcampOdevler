package com.furkansafran.todoapp.ui.fragments.adapter

import android.content.Context
import android.content.Intent
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.furkansafran.todoapp.data.entity.ToDos
import com.furkansafran.todoapp.databinding.CardviewTasarimBinding
import com.furkansafran.todoapp.ui.fragments.AnasayfaFragment
import com.furkansafran.todoapp.ui.fragments.AnasayfaFragmentDirections
import com.furkansafran.todoapp.ui.fragments.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class ToDosAdapter(val fragment: AnasayfaFragment,val toDosListesi : List<ToDos>,val viewModel : AnasayfaViewModel): RecyclerView.Adapter<ToDosAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim : CardviewTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = CardviewTasarimBinding.inflate(LayoutInflater.from(fragment.requireContext()),parent,false)
        return CardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val toDo = toDosListesi.get(position)
        holder.tasarim.textViewName.text = toDo.name
        holder.tasarim.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${toDo.name} yapildi mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                viewModel.toDosSil(toDo.id)
                }.show()
        }
        holder.tasarim.cardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaToDetay(toDo = toDo)
            Navigation.findNavController(it).navigate(gecis)
        }
        holder.tasarim.imageViewAlarm.setOnClickListener {
            Snackbar.make(it, "Alarm Kurulsun mu ?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                  openAlarmAppWithDescription(toDo.name)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return toDosListesi.size
    }
    fun openAlarmAppWithDescription(description: String) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, description)
            putExtra(AlarmClock.EXTRA_HOUR, 9)
            putExtra(AlarmClock.EXTRA_MINUTES, 0)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            fragment.requireActivity().startActivity(intent)
        } catch (e: Exception) {
            Snackbar.make(fragment.requireView(), "Alarm uygulaması açılamadı: ${e.message}", Snackbar.LENGTH_LONG).show()
        }
    }

}
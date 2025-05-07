package com.furkansafran.odev5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.furkansafran.odev5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
     binding.buttonToplama.setOnClickListener {
         val sayi1 = binding.editTextBirinciSayi.text.toString().toIntOrNull()
         val sayi2 = binding.editTextIkinciSayi.text.toString().toIntOrNull()
         if (sayi1 != null && sayi2 != null) {
             val sonuc = Toplama(sayi1, sayi2)
             binding.textViewSonuc.text = "Toplama Sonucu: $sonuc"
         } else {
             binding.textViewSonuc.text = "Geçersiz giriş"

         }
         binding.buttonSifirla.setOnClickListener {
             Sifirlama()
         }
     }

    }
    fun Toplama(sayi1: Int, sayi2: Int): Int {
        return sayi1 + sayi2
    }
    fun Sifirlama(){
        binding.editTextBirinciSayi.text?.clear()
        binding.editTextIkinciSayi.text?.clear()
        binding.textViewSonuc.setText("Toplama Sonucu: 0")
    }
}
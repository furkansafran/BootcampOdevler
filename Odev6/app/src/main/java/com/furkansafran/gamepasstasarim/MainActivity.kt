package com.furkansafran.gamepasstasarim

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.furkansafran.gamepasstasarim.adapter.RvCategoryAdapter
import com.furkansafran.gamepasstasarim.adapter.RvResimAdapter
import com.furkansafran.gamepasstasarim.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {
    private lateinit var kategoriListesi: ArrayList<Kategori>
    private lateinit var adapter: RvResimAdapter
    private lateinit var pAdapter: RvCategoryAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var  resimListesi : ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageView.setImageResource(R.drawable.notifications_24px)
        binding.imageView3.setImageResource(R.drawable.gamepass)
        resimListesi = ArrayList<Int>()
        resimListesi.add(R.drawable.fc24)
        resimListesi.add(R.drawable.farcry4)
        resimListesi.add(R.drawable.gta5)
        resimListesi.add(R.drawable.mc)
        resimListesi.add(R.drawable.mortalkombat)

        kategoriListesi = ArrayList<Kategori>()
        kategoriListesi.add(Kategori("BAĞIMSIZ",R.drawable.lightbulb_24px))
        kategoriListesi.add(Kategori("AİLE",R.drawable.family_restroom_24px))
        kategoriListesi.add(Kategori("KLASİKLER",R.drawable.stadia_controller_24px))
        kategoriListesi.add(Kategori("NİŞANCI",R.drawable.target_24px))
        kategoriListesi.add(Kategori("SPOR",R.drawable.sports_football_24px))
        kategoriListesi.add(Kategori("MACERA",R.drawable.sailing_24px))
        kategoriListesi.add(Kategori("PLATFORM",R.drawable.nature_24px))
        kategoriListesi.add(Kategori("DÖVÜŞ",R.drawable.sports_mma_24px))

        adapter = RvResimAdapter(this,resimListesi)
        binding.RvResim.adapter = adapter
        binding.RvResim.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.RvResim.setHasFixedSize(true)

        pAdapter = RvCategoryAdapter(this,kategoriListesi)
        binding.RvKategori.adapter = pAdapter
        binding.RvKategori.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.RvKategori.setHasFixedSize(true)


    }
}
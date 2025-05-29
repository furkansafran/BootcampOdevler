package com.furkansafran.yemekuygulamasi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.furkansafran.yemekuygulamasi.R
import com.furkansafran.yemekuygulamasi.databinding.FragmentUrunDetayBinding
import com.furkansafran.yemekuygulamasi.ui.fragments.viewmodel.UrunDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UrunDetayFragment : Fragment() {
    private lateinit var binding: FragmentUrunDetayBinding
    private lateinit var viewModel: UrunDetayViewModel
    var sepetAdet = 1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUrunDetayBinding.inflate(inflater, container, false)
        val bundle: UrunDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek
        binding.imageViewGeriTusu.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        binding.textViewDetayYemekAd.text = gelenYemek.yemekAd
        binding.textViewDetayYemekFiyat.text = "${gelenYemek.yemekFiyat} ₺"
        binding.textViewDetaySepetAdet.text = "$sepetAdet"
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemekResimAd}"
        Glide.with(this).load(url).override(600,600).into(binding.imageViewDetayYemek)
        binding.buttonDetayAzalt.setOnClickListener {
            if (sepetAdet > 1) {
                sepetAdet--
                binding.textViewDetaySepetAdet.text = "$sepetAdet"
                binding.textViewToplamFiyat.text = "${gelenYemek.yemekFiyat * sepetAdet} ₺"
            }
        }
        binding.buttonDetayArttir.setOnClickListener {
            sepetAdet++
            binding.textViewDetaySepetAdet.text = "$sepetAdet"
            binding.textViewToplamFiyat.text = "${gelenYemek.yemekFiyat * sepetAdet} ₺"
        }
        binding.textViewToplamFiyat.text = "${gelenYemek.yemekFiyat} ₺"
        binding.buttonDetaySepeteEkle.setOnClickListener {
            viewModel.sepeteYemekEkle(gelenYemek.yemekAd, gelenYemek.yemekResimAd, gelenYemek.yemekFiyat, sepetAdet, "furkan_safran")
            Navigation.findNavController(it).navigate(R.id.urunDetayTosepet)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UrunDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}
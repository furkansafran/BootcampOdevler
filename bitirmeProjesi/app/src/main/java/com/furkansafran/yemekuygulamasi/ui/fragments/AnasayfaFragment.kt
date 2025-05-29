package com.furkansafran.yemekuygulamasi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.furkansafran.yemekuygulamasi.databinding.FragmentAnasayfaBinding
import com.furkansafran.yemekuygulamasi.ui.fragments.adapter.YemeklerAdapter
import com.furkansafran.yemekuygulamasi.ui.fragments.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        viewModel.yemekListesi.observe(viewLifecycleOwner) {
            val yemeklerAdapter = YemeklerAdapter(requireContext(),it)
            binding.rvAnasayfa.adapter = yemeklerAdapter
            binding.rvAnasayfa.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel

    }

}
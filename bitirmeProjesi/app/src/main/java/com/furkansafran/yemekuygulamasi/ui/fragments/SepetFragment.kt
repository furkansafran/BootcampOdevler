package com.furkansafran.yemekuygulamasi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.furkansafran.yemekuygulamasi.R
import com.furkansafran.yemekuygulamasi.databinding.FragmentSepetBinding
import com.furkansafran.yemekuygulamasi.ui.fragments.adapter.SepetAdapter
import com.furkansafran.yemekuygulamasi.ui.fragments.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)
        viewModel.yemekListesi.observe(viewLifecycleOwner) {
            val adapter = SepetAdapter(requireContext(), it, viewModel)
            binding.rvSepet.adapter = adapter
            binding.rvSepet.layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel = tempViewModel

    }
}
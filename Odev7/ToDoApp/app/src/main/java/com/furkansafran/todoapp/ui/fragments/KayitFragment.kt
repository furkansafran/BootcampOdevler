package com.furkansafran.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.furkansafran.todoapp.R
import com.furkansafran.todoapp.databinding.FragmentKayitBinding
import com.furkansafran.todoapp.ui.fragments.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var viewModel: KayitViewModel
    private lateinit var binding  : FragmentKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKayitBinding.inflate(inflater,container,false)
        binding.buttonKayit.setOnClickListener {
            val name = binding.editTextKayit.text.toString()
            viewModel.toDosKayit(name)
            Navigation.findNavController(it).navigate(R.id.kayitToAnasayfa)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}
package com.furkansafran.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.furkansafran.todoapp.R
import com.furkansafran.todoapp.databinding.FragmentDetayBinding
import com.furkansafran.todoapp.ui.fragments.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var viewModel: DetayViewModel
    private lateinit var binding: FragmentDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentDetayBinding.inflate(inflater, container, false)
        val bundle : DetayFragmentArgs by navArgs()
        val gelenToDos = bundle.toDo
        binding.editTextDetay.setText(gelenToDos.name)
        binding.buttonGuncelle.setOnClickListener {
            val name = binding.editTextDetay.text.toString()
            viewModel.toDosGuncelle(gelenToDos.id,name)
          Navigation.findNavController(it).navigate(R.id.detayToAnasayfa)
        }
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayViewModel by viewModels()
        viewModel = tempViewModel

    }

}
package com.furkansafran.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.furkansafran.todoapp.R
import com.furkansafran.todoapp.databinding.FragmentAnasayfaBinding
import com.furkansafran.todoapp.ui.fragments.adapter.ToDosAdapter
import com.furkansafran.todoapp.ui.fragments.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.anasayfaToKayit)
        }
        viewModel.toDosListesi.observe(viewLifecycleOwner) {
            val adapter = ToDosAdapter(this, it,viewModel)
            binding.Rv.adapter = adapter
        }
        binding.Rv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String): Boolean {
                viewModel.toDosAra(query)
                return true
            }

            override fun onQueryTextSubmit(newText: String): Boolean {
                viewModel.toDosAra(newText)
                return true
            }
        })
        binding.Rv.layoutManager = LinearLayoutManager(requireContext())
        return  binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onResume() {
        super.onResume()
        viewModel.toDosYukle()
    }

}
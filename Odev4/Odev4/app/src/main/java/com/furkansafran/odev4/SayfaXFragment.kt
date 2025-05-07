package com.furkansafran.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.furkansafran.odev4.databinding.FragmentSayfaXBinding

class SayfaXFragment : Fragment() {
private lateinit var binding: FragmentSayfaXBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSayfaXBinding.inflate(inflater, container, false)
        binding.buttonXGitY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.SayfaXToSayfaY)
        }
        return binding.root
    }


}
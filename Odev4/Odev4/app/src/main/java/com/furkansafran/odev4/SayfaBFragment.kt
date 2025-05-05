package com.furkansafran.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.furkansafran.odev4.databinding.FragmentSayfaBBinding

class SayfaBFragment : Fragment() {
private lateinit var binding: FragmentSayfaBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSayfaBBinding.inflate(inflater, container, false)
        binding.buttonBGitY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.SayfaBToSayfaY,null, NavOptions.Builder()
                .setPopUpTo(R.id.sayfaAFragment,true)
                .build())

        }
        return binding.root
    }


}
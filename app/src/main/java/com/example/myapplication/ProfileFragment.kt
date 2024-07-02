package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.myapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        val textSend = arguments?.getString("ARG") ?: "ERROR"

        binding?.run {
            prof.text = "$textSend"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.myapplication.databinding.FragmentEprofileBinding

class EprofileFragment: Fragment(R.layout.fragment_eprofile) {

    private var binding: FragmentEprofileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEprofileBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
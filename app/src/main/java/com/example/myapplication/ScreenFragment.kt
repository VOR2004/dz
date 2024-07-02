package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentScreenBinding
import com.squareup.picasso.Picasso

class ScreenFragment: Fragment(R.layout.fragment_screen) {

    private var binding: FragmentScreenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScreenBinding.bind(view)
        val textSend = arguments?.getString("ARG") ?: "ERROR"
        val textSend1 = arguments?.getString("ARG1") ?: "ERROR"
        val textSend2 = arguments?.getString("ARG2") ?: "ERROR"


        binding?.run {
            screen.text = textSend
            screen1.text = textSend1
            Picasso.get().load(textSend2).into(image1)
            imageButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_screenFragment_to_friendsFragment,
                )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
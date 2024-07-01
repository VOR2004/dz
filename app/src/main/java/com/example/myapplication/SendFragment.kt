package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSendBinding
import com.google.android.material.snackbar.Snackbar

class SendFragment: Fragment(R.layout.fragment_send) {

    private var binding: FragmentSendBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendBinding.bind(view)
        binding?.run {
            send.setOnClickListener {
                val bundle = Bundle()
                val text = etE.text?.toString()
                bundle.putString("ARG", text)
                if (text != "") {
                    findNavController().navigate(
                        R.id.action_sendFragment_to_profileFragment,
                        args = bundle
                    )}
                else {
                    Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}